/**
 * Created with IntelliJ IDEA.
 * User: baljeetsandhu
 * Date: 5/10/13
 * Time: 3:58 PM
 * To change this template use File | Settings | File Templates.
 */
define(
    ['knockout', 'app/ticket/TradeService', 'log', 'stringjs'],
    function (ko, tradeService, log, S) {
        "use strict";

        function TicketViewModel() {
            this.trancheId = ko.observable(100);
            this.quantity = ko.observable(100);
            this.price = ko.observable(100);
            this.tradeDate = ko.observable();
            this.entryDate = ko.observable(new Date());
            this.bookName = ko.observable(100);
            this.counterParty = ko.observable(100);
            this.notes = ko.observable(100);
            this.buySell = ko.observable(100);

            this._status = ko.observable('');
        }

        function filterPrivateVars(key, value) {
            if (key.charAt(0) == '_') {
                return undefined;
            }
            if (S(key).endsWith('Date')) {
                return Date.parse(value);
            }
            return value;
        }

        TicketViewModel.prototype.saveTrade = function () {
            var attr = this._status;
            var tradeData = ko.toJSON(this, filterPrivateVars);
            log.info('Saving trade: ' + tradeData);

            tradeService.saveTrade(tradeData,
                function (data, status) {
                    log.info(status);
                    attr(status);
                });
        };

        TicketViewModel.prototype.resetStatus = function () {
            this._status('');
        };

        TicketViewModel.prototype.onSelect = function (dateText) {
            var vm = ko.dataFor(this);
            vm.tradeDate(dateText);
            log.info(dateText);
        };

        return TicketViewModel;
    }
);