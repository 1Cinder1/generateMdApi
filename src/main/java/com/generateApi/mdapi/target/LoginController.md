#### 1.1 login

| 接口 | /uaa/login                                         |
| ---- | ------------------------------------------------------------ |
| 描述 | 登录接口                                                 |
| 验证 | Token，客户端验证，参数：<br />Header中：<br />**Authorization:** ==Bearer {token} |
| 方法 | POST                                                         |

**Request**
| 参数名        | 类型   | 是否必须 | 参数位置    | 描述           |
| ------------- | ------ | -------- | ----------- | -------------- |
| Authorization | String  | Y        | header     | 用户Token，Bearer协议 
| loginParams | Map | Y        | body      | null |
| httpHeaders | HttpHeaders | Y        | header      | null |


**Response**


| 参数名         | 类型       | 是否必须 | 描述                        |
| -------------- | ---------- | -------- | --------------------------- |
| success           | Integer | Y        | null                    |
| code           | Long | Y        | null                    |
| message           | String | Y        | null                    |
| data           | Object | Y        | null                    |


#### 1.2 reviseCaptcha

| 接口 | /uaa/revise-Captcha                                         |
| ---- | ------------------------------------------------------------ |
| 描述 | 重置密码发送验证码                                                 |
| 验证 | Token，客户端验证，参数：<br />Header中：<br />**Authorization:** ==Bearer {token} |
| 方法 | GET                                                         |

**Request**
| 参数名        | 类型   | 是否必须 | 参数位置    | 描述           |
| ------------- | ------ | -------- | ----------- | -------------- |
| Authorization | String  | Y        | header     | 用户Token，Bearer协议 

**Response**


| 参数名         | 类型       | 是否必须 | 描述                        |
| -------------- | ---------- | -------- | --------------------------- |
| success           | Integer | Y        | null                    |
| code           | Long | Y        | null                    |
| message           | String | Y        | null                    |
| data           | Object | Y        | null                    |


#### 1.3 revisePassword

| 接口 | /uaa/revise-password                                         |
| ---- | ------------------------------------------------------------ |
| 描述 | 重置密码                                                 |
| 验证 | Token，客户端验证，参数：<br />Header中：<br />**Authorization:** ==Bearer {token} |
| 方法 | POST                                                         |

**Request**
| 参数名        | 类型   | 是否必须 | 参数位置    | 描述           |
| ------------- | ------ | -------- | ----------- | -------------- |
| Authorization | String  | Y        | header     | 用户Token，Bearer协议 
| newPassword | String | Y        | header      | null |
| captcha | String | Y        | header      | null |


**Response**


| 参数名         | 类型       | 是否必须 | 描述                        |
| -------------- | ---------- | -------- | --------------------------- |
| success           | Integer | Y        | null                    |
| code           | Long | Y        | null                    |
| message           | String | Y        | null                    |
| data           | Object | Y        | null                    |


