/**
 * Created with IntelliJ IDEA.
 * User: baljeetsandhu
 * Date: 5/16/13
 * Time: 12:39 PM
 * To change this template use File | Settings | File Templates.
 */

define(["knockout", "log", "jquery", "js!jqxcore", "js!jqxsplitter", "domReady!"], function (ko, log, $) {
    "use strict";

    ko.bindingHandlers.jqxSplitter = {

        init: function (element, valueAccessor, allBindingsAccessor, viewModel, bindingContext) {
            var value = ko.utils.unwrapObservable(valueAccessor());
            var allBindings = allBindingsAccessor();
            log.debug("Splitter binding init");


        },
        update: function (element, valueAccessor, allBindingsAccessor, viewModel, bindingContext) {
            log.info("Splitter binding update");
            $(element).jqxSplitter({width: '100%', height: '99%', panels: [{size: '30%'},{size: '70%'}], resizable: true, orientation: 'horizontal', showSplitBar: 'false'});
        }
    };

});
