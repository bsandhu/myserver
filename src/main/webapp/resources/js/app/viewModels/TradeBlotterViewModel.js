/**
 * Created with IntelliJ IDEA.
 * User: baljeetsandhu
 * Date: 5/16/13
 * Time: 3:29 PM
 * To change this template use File | Settings | File Templates.
 */

define(
    ['knockout', 'log', 'jquery', 'stringjs'],
    function (ko, log, $, S) {
        "use strict";

        function TradeBlotterViewModel() {
            this.trades = ko.observableArray([]);
            this.allowSorting = ko.observable(true);
            this.selectColumns = ko.observable(true);
            this.selectionMode = ko.observable('single');
            this.widget = ko.observable();
            this.pageSetup = ko.observable({pageSize: 10, input: true})

            this.attributes = {style: 'font-size: 14px'};
            this.columnSetup = ko.observableArray([
                { field: 'tradeDate', title: 'Trade Date', width: 180, attributes: this.attributes},
                { field: 'entryDate', title: 'Entry Date', width: 80, attributes: this.attributes},
                { field: 'counterParty', title: 'counterParty', width: 90, attributes: this.attributes},
                { field: 'bookName', title: 'bookName', width: 90, attributes: this.attributes},
                { field: 'notes', title: 'notes', width: 90, attributes: this.attributes,
                    template: function (dataItem) {
                        return dataItem.notes.substr(0, 10) + '...';
                    }},
                { field: 'price', title: 'price', width: 90, attributes: this.attributes},
                { field: 'trancheId', title: 'trancheId', width: 100, attributes: this.attributes},
                { field: 'Quantity', title: 'Quantity', width: 100, attributes: this.attributes},
                { field: 'buySell', title: 'buySell', width: 90, attributes: this.attributes},
                { command: ["edit", "destroy"], title: "&nbsp;", width: 150}
            ]);
            this.loadTrades();
        }

        TradeBlotterViewModel.prototype.onChange = function (ev) {
            log.info("Grid selection ev: " + ev);
            var selectedRows = this.select();
            var selectedDataItems = [];
            for (var i = 0; i < selectedRows.length; i++) {
                var dataItem = this.dataItem(selectedRows[i]);
                selectedDataItems.push(dataItem);
            }
            log.info("Selected row: " + JSON.stringify(selectedDataItems));
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
