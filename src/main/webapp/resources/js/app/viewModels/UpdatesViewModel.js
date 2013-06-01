define(
    ['knockout', 'jquery', 'log', 'postal', 'app/utils/PostalConfig'],
    function (ko, $, log, postal, config) {
        "use strict";

        function UpdatesViewModel() {
            this.sendUpdates = ko.observable(false);
            this.updateRate = ko.observable(0);
            this.maxValue = ko.observable(100);
            this.minValue = ko.observable(1);
            this.largeStep = ko.observable(1);
            this.smallStep = ko.observable(1);

            this.updateRate.subscribe(this.updateRateChange);
        }

        UpdatesViewModel.prototype.updateRateChange = function (value) {
            log.info("Starting Updates/sec: " + value);
            $.ajax({
                type: "GET",
                url: "../../../../trades/startUpdates/" + value,
                contentType: "application/json"
            });
        };

        UpdatesViewModel.prototype.toggleUpdates = function (data, event) {
            if (!event.target.checked) {
                log.info("Stopping Updates");
                $.ajax({
                    type: "GET",
                    url: "../../../../trades/stopUpdates/"
                });
            } else {
                this.updateRateChange(this.updateRate());
            }
        };


        return UpdatesViewModel;

    });