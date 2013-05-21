define(
    ['knockout', 'jquery', 'log', 'postal', 'app/utils/PostalConfig'],
    function (ko, $, log, postal, config) {
        "use strict";

        function EventsViewModel() {
            this.events = ko.observableArray([]);
            this.historyVisible = ko.observable(true);
            this.winHeight = ko.observable(200);
            this.winWidth = ko.observable(200);
            this.widget = ko.observable(null);

            this.setupSubscriptions();
        }

        EventsViewModel.prototype.setupWindowSize = function () {
         //                _winHeight($('#topRightSplitter').height());
                newValue.width = 500;
                _winHeight(500);
                _winWidth($('#topRightSplitter').width());
                log.info($('#topRightSplitter').width());
//                debugger;
        };

        EventsViewModel.prototype.setupSubscriptions = function () {
            var channel = postal.channel(config.TRADE_BLOTTER_CHANNEL);
            var _events = this.events;

            channel.subscribe('Selection', function (msg) {
                log.debug("Got Selection ev. " + msg);
                var msgObj = JSON.parse(msg);
                _events.push({id: msgObj.tradeId, name: msgObj.counterParty});
            });
        };

        EventsViewModel.prototype.showHistory = function () {
            this.historyVisible(true);
        };

        EventsViewModel.prototype.removeItem = function (item) {
            log.info("Removing: " + item);
            this.events().remove(item);
        };

        return EventsViewModel;
    }
);