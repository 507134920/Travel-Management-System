package com.lj.trshop.util;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

    public static String app_id = "2016102100730930";

    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCYjmRP4dWzoaGtnfMn9F8lAWSGpryR9UJ0dGZBd9oG0uvGtB6Iwd6Z4j3JcAHiCNLKTnTlV50YqLL3itb00SqsEKZBYdLJLYVymMJ4cQWc8EwIdsz82O1t4nbwa2aY5UwZhV5wf1uGNGQW6TcCKM/Kh/U1m+zOl1WUkcUO4TedhLwh4mpGCsYacPOXAxyQV7DywbP+kQOrIKk1kwYQV/7exV/hRxaI4jrHoa2iDQ30O+min5H96A4lEj39nFp/7VFxYlZmkSxFuzYVlX/8XmfOQGCPfi4oNARyIBtZxcZ1P19vm02o8169Gc5AWMLzutlFfpYSaFO82k3CfyRN7+P9AgMBAAECggEAHqvCDy1gQZUlZDp1QHspBc+Z3lh3YQDmM3OTe2YVN3oAXRqpaOVRU67grTcPqdoMRxAvAEz1EJgaIxqOzPmgkqdmRY7dSgUU500/C+ftMPg+0RTRcaRLV+RH9V4iamrvOdJOgl+YjwrJdLG+lXiPDjD3Y6fNnFtgoVYNQEiXXduZCnTXi+pqk9Q6hJ6tDeSR0hjVMkWlE5FwFEeHXiPOsNtkkKr2EvgmgzSPYRb+XWNQ4JL7O9Iu/c6XAptK+Nx9Re4tjHrtUBR7eutgAW6TdUVEHItN0ZmoW/Gv/VijsfcU4qWGDETC607upeM21r6jTMeSAsF+YqmeYkhVTgGsIQKBgQDtWHJIhl4DoazbSp9wN8HOk52qw53sHDqe7tr3P68biIyYCaJU9+ck7EvB5vCvIO9dvTkCXs9jcBwrTMGs86zvXjk/QkiuDdCnvfrVpVd0M5TxyvRWpl/+fmGS1Wyg2lUHzBXkpkWiGLudMW7BGakXH7nNsCCGfne6UnQdh74zMwKBgQCki+1fcPyunDppku7o4GdCdLHOQqqEVqkKAn2y/7HPMfcVA6QA3kQcUd9GPT2k107BmcjgeHGFP1g2unJF8rFrgmJgxA9p9ByxK8tCaqOwiY7OUxU4ZxqNYcB6PF645/TvJ0hPo88rxq7S7U3cCxSEN+YRtCBMnnF6LnmMUwmMDwKBgBlAyOAYk9Y1FIw8k1xAQnm1URhDOgFOO5p/dYLLHtmCHNtsYv5BZjGShrj51m/7xBwoLvGmntBItGaTAyRgxOyvDM5DQjJqu+GtIAwtTHHLrzRO0NKLXzlXvw/9b1JqCJQMzeOHIW+OzB98i/k1vrz8HivZaoyE1j5X2YzuzXjrAoGBAInmaw0tl9aOP7Xy2h540pEzU0BVRqqaJhipdcbp246VhUkrP+sqW1KQmto2wM7BUtOVmm/lAN528+sJ3nMYrfA32VLXfUOCvfkNhs8mqABviCsKHiKi5fHPFoxaw9ebLf6voT59PkalwCYtkq7y6kLUxg/YMamEr/2BrYQYo0upAoGBAJNnpBGstIQiaYdViyOB9pMJ1koP3S+DmXtZVjlBvfEcc9Eb/A7lQN6rKlzA8mTa3mRoGleQhKKGRi81cj7E2GuqV+1qd+AcJ9gZloujdd+rbhNnOqFG5gYnDo0HZvRPPa9UnrAQQXm3T9FNjbu/j1z5TFXoUBYeALR/hw/mnsSI";

    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4H3tnXNnjRc9OtKn7nXYooTSAVk0Cxa9XLjwYFEUDNr6Ro7ffUimRepfLscFdeZso+YuNmYQJZ35OSxjdRl1X30QlbhrmoOMJd/7+A6dOD/fzdCx+KwGYaXixFcJ/xJ298rsFiOhnWONHcVAzDow36MozpOEnXSs6uCha9LHBs9yEkKoU3N611pGlCUnmyft1sgmaGgrAudsDINSCoDVKZ38ZneGLSyfJDk0u1qDVn+w2nJj2sNUuuMyEZo6gl8Kqd7u6/vXtRVLFLofEQyW0c+bGHF9NG7rSv037oItpuJG2tqfEaDVdoEvNJwDbt/RmG/TFPy5/uw7ggO+qu/WQwIDAQAB";

    public static String notify_url = "http://localhost:8080/trshop/alipayNotifyNotice";

    public static String return_url = "http://localhost:8080/trshop/alipayReturnNotice";

    public static String sign_type = "RSA2";

    public static String charset = "utf-8";

    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";


}
