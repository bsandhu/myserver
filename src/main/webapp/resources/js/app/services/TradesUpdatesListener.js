define(["jquery", "log", 'postal', 'app/utils/PostalConfig'],
    function ($, log, postal, config) {
        "use strict";

        var obj = {};
        obj.start = function () {
            var request = new $.atmosphere.AtmosphereRequest(),
                socket = $.atmosphere,
                channel = postal.channel(config.TRADE_UPDATES_CHANNEL);
            request.url = document.location.origin + '/myserver/trades/updates';
            request.contentType = "application/json";
            request.transport = 'streaming';
            request.fallbackTransport = 'long-polling';

            request.onMessage = function (response) {
                var message = response.responseBody;
                try {
                    log.info("Msg: " + message);
                    channel.publish("Update", message);
                } catch (e) {
                    log.error('Error: ', message.data);
                }
            };

            request.onOpen = function (response) {
                log.info("Connection open: " + response);
            };

            request.onError = function (response) {
                log.error("Updates listener error: " + response);
                socket.disconnect();
            };

            request.onClose = function (response) {
                log.error("Socket close. Disconnecting: " + response);
                socket.close();
            };

            log.debug('Subscribing to trade updates..');
            socket.subscribe(request);
            log.debug('Done');

        };
        return obj;
    });
