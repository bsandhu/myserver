define(
    ['knockout', 'log', 'jquery', 'app/services/TradesUpdatesListener'],
    function (ko, log, $, TradesUpdatesListener) {
        "use strict";

        function AppViewModel() {
            log.info('Init App view model');
            TradesUpdatesListener.start();
        }

        return AppViewModel;
    }
);