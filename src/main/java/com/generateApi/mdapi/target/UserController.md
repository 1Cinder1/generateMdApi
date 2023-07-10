#### 1.1 editBasicInfo

| 接口 | /uaa/user/editBasicInfo                                         |
| ---- | ------------------------------------------------------------ |
| 描述 | 修改用户基本信息                                                 |
| 验证 | Token，客户端验证，参数：<br />Header中：<br />**Authorization:** ==Bearer {token} |
| 方法 | POST                                                         |

**Request**
| 参数名        | 类型   | 是否必须 | 参数位置    | 描述           |
| ------------- | ------ | -------- | ----------- | -------------- |
| Authorization | String  | Y        | header     | 用户Token，Bearer协议 
| basicInfoVo | BasicInfoVo | Y        | body      | null |


**Response**


| 参数名         | 类型       | 是否必须 | 描述                        |
| -------------- | ---------- | -------- | --------------------------- |
| success           | Integer | Y        | null                    |
| code           | Long | Y        | null                    |
| message           | String | Y        | null                    |
| data           | Object | Y        | null                    |


#### 1.2 editHealthInfo

| 接口 | /uaa/user/editHealthInfo                                         |
| ---- | ------------------------------------------------------------ |
| 描述 | 修改用户健康相关信息                                                 |
| 验证 | Token，客户端验证，参数：<br />Header中：<br />**Authorization:** ==Bearer {token} |
| 方法 | POST                                                         |

**Request**
| 参数名        | 类型   | 是否必须 | 参数位置    | 描述           |
| ------------- | ------ | -------- | ----------- | -------------- |
| Authorization | String  | Y        | header     | 用户Token，Bearer协议 
| healthInfoVo | HealthInfoVo | Y        | body      | null |


**Response**


| 参数名         | 类型       | 是否必须 | 描述                        |
| -------------- | ---------- | -------- | --------------------------- |
| success           | Integer | Y        | null                    |
| code           | Long | Y        | null                    |
| message           | String | Y        | null                    |
| data           | Object | Y        | null                    |


#### 1.3 getUserInfo

| 接口 | /uaa/user/info                                         |
| ---- | ------------------------------------------------------------ |
| 描述 | 获取用户信息                                                 |
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


