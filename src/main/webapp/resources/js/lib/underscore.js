/**
 * Puts a little wrapper around Underscore so that it can be cleanly injected to
 * refering modules sunch as Postal.
 */
define(['js!underscoreNonAMD!exports=_'], function (_) {
    "use strict";
    return _;
});