define(
    ['knockout', 'log', 'postal', 'app/utils/PostalConfig'],
    function (ko, log, postal, config) {
        "use strict";

        function EventsViewModel() {
            this.events = ko.observableArray([
                {id: 100, name: 'AAA'},
                {id: 200, name: 'BBB'}
            ]);

            this.setupSubscriptions();
        }

        EventsViewModel.prototype.setupSubscriptions = function () {
            var channel = postal.channel(config.TRADE_BLOTTER_CHANNEL);
            var _events = this.events;

            channel.subscribe('Selection', function (msg) {
                log.debug("Got Selection ev. " + msg);
                var msgObj = JSON.parse(msg);
                _events.push({id: msgObj.tradeId, name: msgObj.counterParty});
            });
        }

        EventsViewModel.prototype.removeItem = function (item) {
            log.info("Removing: " + item);
            this.events().remove(item);
        };

        return EventsViewModel;
    }
);