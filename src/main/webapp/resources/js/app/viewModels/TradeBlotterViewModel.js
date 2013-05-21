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
            this.allowSorting = ko.observable(true);
            this.selectColumns = ko.observable(true);
            this.selectionMode = ko.observable('single');
            this.widget = ko.observable();

            this.columnSetup = ko.observableArray([
                { field: 'tradeDate', title: 'Trade Date', width: 180 },
                { field: 'entryDate',title: 'Entry Date', width: 80 },
                { field: 'counterParty',title: 'counterParty', width: 90 },
                { field: 'bookName',title: 'bookName', width: 90 },
                { field: 'notes', title: 'notes', width: 90 },
                { field: 'price', title: 'price', width: 90 },
                { field: 'trancheId', title: 'trancheId', width: 100 },
                { field: 'Quantity', title: 'Quantity', width: 100 },
                { field: 'buySell',title: 'buySell', width: 90 },
                { command: ["edit", "destroy"], title: "&nbsp;", width: "172px" }]);
            this.loadTrades();

            this.widget.subscribe(function(grid) {
                log.info("GRID OBJ OPDATED: " + grid);
            });
        }

        TradeBlotterViewModel.prototype.onChange = function (arg) {
            log.info("Grid change: " + arg);
        };

        TradeBlotterViewModel.prototype.loadTrades = function () {
            var _trades = this.trades;
            $.get('../../../../trade/trades/100', function (data, status) {
                log.info('Loaded trades: ' + status);
                log.debug(ko.toJS(data));
                _trades(JSON.parse(data));
            });
        };

        return TradeBlotterViewModel;
    }
);
