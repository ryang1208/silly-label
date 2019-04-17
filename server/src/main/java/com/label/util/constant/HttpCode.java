package com.label.util.constant;

public class HttpCode {

    public static final int StatusContinue = 100; // RFC 7231, 6.2.1
    public static final int StatusSwitchingProtocols = 101; // RFC 7231, 6.2.2
    public static final int StatusProcessing = 102; // RFC 2518, 10.1

    public static final int StatusOK = 200; // RFC 7231, 6.3.1
    public static final int StatusCreated = 201; // RFC 7231, 6.3.2
    public static final int StatusAccepted = 202; // RFC 7231, 6.3.3
    public static final int StatusNonAuthoritativeInfo = 203; // RFC 7231, 6.3.4
    public static final int StatusNoContent = 204; // RFC 7231, 6.3.5
    public static final int StatusResetContent = 205; // RFC 7231, 6.3.6
    public static final int StatusPartialContent = 206; // RFC 7233, 4.1
    public static final int StatusMultiStatus = 207; // RFC 4918, 11.1
    public static final int StatusAlreadyReported = 208; // RFC 5842, 7.1
    public static final int StatusIMUsed = 226; // RFC 3229, 10.4.1

    public static final int StatusMultipleChoices = 300; // RFC 7231, 6.4.1
    public static final int StatusMovedPermanently = 301; // RFC 7231, 6.4.2
    public static final int StatusFound = 302; // RFC 7231, 6.4.3
    public static final int StatusSeeOther = 303; // RFC 7231, 6.4.4
    public static final int StatusNotModified = 304; // RFC 7232, 4.1
    public static final int StatusUseProxy = 305; // RFC 7231, 6.4.5
    public static final int _ = 306; // RFC 7231, 6.4.6 (Unused)
    public static final int StatusTemporaryRedirect = 307; // RFC 7231, 6.4.7
    public static final int StatusPermanentRedirect = 308; // RFC 7538, 3

    // 自定义
    public static final int StatusUserNotLogin = 310;

    public static final int StatusBadRequest = 400; // RFC 7231, 6.5.1
    public static final int StatusUnauthorized = 401; // RFC 7235, 3.1
    public static final int StatusPaymentRequired = 402; // RFC 7231, 6.5.2
    public static final int StatusForbidden = 403; // RFC 7231, 6.5.3
    public static final int StatusNotFound = 404; // RFC 7231, 6.5.4
    public static final int StatusMethodNotAllowed = 405; // RFC 7231, 6.5.5
    public static final int StatusNotAcceptable = 406; // RFC 7231, 6.5.6
    public static final int StatusProxyAuthRequired = 407; // RFC 7235, 3.2
    public static final int StatusRequestTimeout = 408; // RFC 7231, 6.5.7
    public static final int StatusConflict = 409; // RFC 7231, 6.5.8
    public static final int StatusGone = 410; // RFC 7231, 6.5.9
    public static final int StatusLengthRequired = 411; // RFC 7231, 6.5.10
    public static final int StatusPreconditionFailed = 412; // RFC 7232, 4.2
    public static final int StatusRequestEntityTooLarge = 413; // RFC 7231, 6.5.11
    public static final int StatusRequestURITooLong = 414; // RFC 7231, 6.5.12
    public static final int StatusUnsupportedMediaType = 415; // RFC 7231, 6.5.13
    public static final int StatusRequestedRangeNotSatisfiable = 416; // RFC 7233, 4.4
    public static final int StatusExpectationFailed = 417; // RFC 7231, 6.5.14
    public static final int StatusTeapot = 418; // RFC 7168, 2.3.3
    public static final int StatusMisdirectedRequest = 421; // RFC 7540, 9.1.2
    public static final int StatusUnprocessableEntity = 422; // RFC 4918, 11.2
    public static final int StatusLocked = 423; // RFC 4918, 11.3
    public static final int StatusFailedDependency = 424; // RFC 4918, 11.4
    public static final int StatusTooEarly = 425; // RFC 8470, 5.2.
    public static final int StatusUpgradeRequired = 426; // RFC 7231, 6.5.15
    public static final int StatusPreconditionRequired = 428; // RFC 6585, 3
    public static final int StatusTooManyRequests = 429; // RFC 6585, 4
    public static final int StatusRequestHeaderFieldsTooLarge = 431; // RFC 6585, 5
    public static final int StatusUnavailableForLegalReasons = 451; // RFC 7725, 3

    public static final int StatusInternalServerError = 500; // RFC 7231, 6.6.1
    public static final int StatusNotImplemented = 501; // RFC 7231, 6.6.2
    public static final int StatusBadGateway = 502; // RFC 7231, 6.6.3
    public static final int StatusServiceUnavailable = 503; // RFC 7231, 6.6.4
    public static final int StatusGatewayTimeout = 504; // RFC 7231, 6.6.5
    public static final int StatusHTTPVersionNotSupported = 505; // RFC 7231, 6.6.6
    public static final int StatusVariantAlsoNegotiates = 506; // RFC 2295, 8.1
    public static final int StatusInsufficientStorage = 507; // RFC 4918, 11.5
    public static final int StatusLoopDetected = 508; // RFC 5842, 7.2
    public static final int StatusNotExtended = 510; // RFC 2774, 7
    public static final int StatusNetworkAuthenticationRequired = 511; // RFC 6585, 6

}
