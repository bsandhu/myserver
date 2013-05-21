define(
    ['knockout', 'jquery', 'log', 'postal', 'app/utils/PostalConfig'],
    function (ko, $, log, postal, config) {
        "use strict";

        function EventsViewModel() {
            this.events = ko.observableArray(JSON.parse(localStorage.getItem('EventsHistory')) || []);
            this.historyVisible = ko.observable(true);
            this.winHeight = ko.observable($('#topRightSplitter').height() - 100);
            this.winWidth = ko.observable($('#topRightSplitter').width());
            this.widget = ko.observable(null);

            this.setupSubscriptions();
        }

        EventsViewModel.prototype.setupSubscriptions = function () {
            var channel = postal.channel(config.TRADE_BLOTTER_CHANNEL),
                _events = this.events;

            channel.subscribe('Selection', function (msg) {
                log.debug("Got Selection ev. " + msg);
                var msgObj = JSON.parse(msg);
                var msgDict = {id: msgObj.tradeId, name: msgObj.counterParty};
                _events.push(msgDict);

                var events = JSON.parse(localStorage.getItem('EventsHistory')) || [];
                events.push(msgDict);
                localStorage.setItem('EventsHistory', JSON.stringify(events));
            });

            $(window).bind('storage', function (e) {
                log.info('Storage event');
                if (e.originalEvent.key == 'EventsHistory') {
                    _events(JSON.parse(e.originalEvent.newValue));
                }
            });
        };

        EventsViewModel.prototype.clearHistory = function () {
            localStorage.setItem('EventsHistory', JSON.stringify([]));
            this.events([]);
        };

        return EventsViewModel;
    }
);