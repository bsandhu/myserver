/**
 * Created with IntelliJ IDEA.
 * User: baljeetsandhu
 * Date: 5/16/13
 * Time: 3:29 PM
 * To change this template use File | Settings | File Templates.
 */

define(
    ['knockout', 'log', 'jquery'],
    function (ko, log, $) {
        "use strict";

        function TradeBlotterViewModel() {
            this.trades = ko.observableArray([]);
            this.loadTrades();
        }

        TradeBlotterViewModel.prototype.loadTrades = function () {
            var _trades = this.trades;
            $.get('trade/trades/100', function (data, status) {
                log.info('Loaded trades: ' + status);
                log.debug(ko.toJS(data));
                _trades(JSON.parse(data));
            });
        };

        return TradeBlotterViewModel;
    }
);
