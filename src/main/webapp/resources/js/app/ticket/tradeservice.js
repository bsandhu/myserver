/**
 * Created with IntelliJ IDEA.
 * User: baljeetsandhu
 * Date: 5/10/13
 * Time: 9:11 PM
 * To change this template use File | Settings | File Templates.
 */

define(
    ["jquery"],
    function ($) {
        "use strict";

        var obj = {};
        obj.saveTrade = function () {
            var result;
            $.ajax({
                type: "GET",
                url: "trade/100"
            }).done(function (msg) {
                console.log(msg);
                result = msg;
            }).error(function (msg) {
                alert("Error: " + msg);
                return msg;
            });

            return result;
        };

        return obj;
    }
);

