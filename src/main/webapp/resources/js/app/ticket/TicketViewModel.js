/**
 * Created with IntelliJ IDEA.
 * User: baljeetsandhu
 * Date: 5/10/13
 * Time: 3:58 PM
 * To change this template use File | Settings | File Templates.
 */
define(
    'TradeViewModel',
    ['knockout', 'domReady!'],
    function(ko, tradeService) {

        ;
        return {
            TradeViewModel: function() {
                this.trancheId = ko.observable(100);
            };
        };
    }
);