/**
 * Created with IntelliJ IDEA.
 * User: baljeetsandhu
 * Date: 5/10/13
 * Time: 3:58 PM
 * To change this template use File | Settings | File Templates.
 */
define(
    ['knockout', 'app/ticket/TradeService'],
    function (ko, tradeService) {
        "use strict";

        function TicketViewModel() {
            this.trancheId = ko.observable(100);
            this.status = ko.observable('');
        }

        TicketViewModel.prototype.saveTrade = function () {
            var msg = tradeService.saveTrade();
            console.log(msg);
            this.status = msg;
        };

        return TicketViewModel;
    }
);