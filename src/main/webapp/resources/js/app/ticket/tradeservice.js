/**
 * Created with IntelliJ IDEA.
 * User: baljeetsandhu
 * Date: 5/10/13
 * Time: 9:11 PM
 * To change this template use File | Settings | File Templates.
 */

define(
    'TradeService',
    [],
    function saveTrade() {
        $.ajax({
            type: "GET",
            url: "trade/100",
        }).done(function (msg) {
            alert("Trade Saved: " + msg);
        }).error(function (msg) {
            alert("Error: " + msg);
        });
    }
);
