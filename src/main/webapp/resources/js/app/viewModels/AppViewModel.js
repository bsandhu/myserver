define(
    ['knockout',
        'log',
        'jquery',
        'app/viewModels/TicketViewModel',
        'app/viewModels/EventsViewModel',
        'app/viewModels/TradeBlotterViewModel'],
    function (ko, log, $, TicketViewModel, EventsViewModel, TradeBlotterViewModel) {
        "use strict";

        function AppViewModel() {
            this.eventsViewModel = ko.observable(new EventsViewModel());
            this.ticketViewModel = ko.observable(new TicketViewModel());
            this.tradeBlotterViewModel = ko.observable(new TradeBlotterViewModel());
        }

        return AppViewModel;
    }
);