define(
    ['knockout', 'log', 'jquery'],
    function (ko, log, $) {
        "use strict";

        function AppViewModel() {
            log.info('Init App view model');
        }

        return AppViewModel;
    }
);