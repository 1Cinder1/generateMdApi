#### 1.1 sendEmailCode

| 接口 | /uaa/signup/send/emailcode                                         |
| ---- | ------------------------------------------------------------ |
| 描述 | 注册发送邮箱验证码                                                 |
| 验证 | Token，客户端验证，参数：<br />Header中：<br />**Authorization:** ==Bearer {token} |
| 方法 | GET                                                         |

**Request**
| 参数名        | 类型   | 是否必须 | 参数位置    | 描述           |
| ------------- | ------ | -------- | ----------- | -------------- |
| Authorization | String  | Y        | header     | 用户Token，Bearer协议 
| email | String | Y        | url      | null |


**Response**


| 参数名         | 类型       | 是否必须 | 描述                        |
| -------------- | ---------- | -------- | --------------------------- |
| success           | Integer | Y        | null                    |
| code           | Long | Y        | null                    |
| message           | String | Y        | null                    |
| data           | Object | Y        | null                    |


#### 1.2 signupByEmail

| 接口 | /uaa/signup/email                                         |
| ---- | ------------------------------------------------------------ |
| 描述 | 通过邮箱注册                                                 |
| 验证 | Token，客户端验证，参数：<br />Header中：<br />**Authorization:** ==Bearer {token} |
| 方法 | POST                                                         |

**Request**
| 参数名        | 类型   | 是否必须 | 参数位置    | 描述           |
| ------------- | ------ | -------- | ----------- | -------------- |
| Authorization | String  | Y        | header     | 用户Token，Bearer协议 
| signupByEmailVo | SignupByEmailVo | Y        | body      | null |


**Response**


| 参数名         | 类型       | 是否必须 | 描述                        |
| -------------- | ---------- | -------- | --------------------------- |
| success           | Integer | Y        | null                    |
| code           | Long | Y        | null                    |
| message           | String | Y        | null                    |
| data           | Object | Y        | null                    |


