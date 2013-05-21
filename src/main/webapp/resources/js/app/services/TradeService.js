/**
 * Created with IntelliJ IDEA.
 * User: baljeetsandhu
 * Date: 5/10/13
 * Time: 9:11 PM
 * To change this template use File | Settings | File Templates.
 */

define(
    ["jquery", "log"],
    function ($, log) {
        "use strict";

        var obj = {};

        obj.saveTrade = function (tradeData, callback) {
            log.debug("Calling trade service to save");
            $.ajax({
                type: "POST",
                url: "../../../../trade/save",
                data: tradeData,
                contentType: "application/json"
            }).always(callback);
        };

        return obj;
    }
);

