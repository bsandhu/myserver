define(
    ['knockout', 'log', 'stringjs', 'jquery'],
    function (ko, log, S, $) {
        "use strict";

        function EventsViewModel() {
            this.events = ko.observableArray([
                {id: 100, name: 'AAA'},
                {id: 200, name: 'BBB'}
            ]);
        }

        EventsViewModel.prototype.removeItem = function (item) {
            log.info("Removing: " + item);
            this.events().remove(item);
        };

        return EventsViewModel;
    }
);