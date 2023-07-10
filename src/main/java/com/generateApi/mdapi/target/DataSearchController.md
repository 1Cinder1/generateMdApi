#### 1.1 getAverageData

| 接口 | /uaa/data/average                                         |
| ---- | ------------------------------------------------------------ |
| 描述 | 获取所有常变数据的平均值                                                 |
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


#### 1.2 getBMIHistory

| 接口 | /uaa/data/heart-history                                         |
| ---- | ------------------------------------------------------------ |
| 描述 | 获取心脏类数据历史列表 BMI diffWalking sleepTime                                                 |
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


#### 1.3 getStokeHistory

| 接口 | /uaa/data/stoke-history                                         |
| ---- | ------------------------------------------------------------ |
| 描述 | 获取中风类历史列表                                                 |
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


#### 1.4 submitAll

| 接口 | /uaa/data/submit-data                                         |
| ---- | ------------------------------------------------------------ |
| 描述 | 提交所有数据                                                 |
| 验证 | Token，客户端验证，参数：<br />Header中：<br />**Authorization:** ==Bearer {token} |
| 方法 | POST                                                         |

**Request**
| 参数名        | 类型   | 是否必须 | 参数位置    | 描述           |
| ------------- | ------ | -------- | ----------- | -------------- |
| Authorization | String  | Y        | header     | 用户Token，Bearer协议 
| dataSubmitVo | DataSubmitVo | Y        | body      | null |


**Response**


| 参数名         | 类型       | 是否必须 | 描述                        |
| -------------- | ---------- | -------- | --------------------------- |
| success           | Integer | Y        | null                    |
| code           | Long | Y        | null                    |
| message           | String | Y        | null                    |
| data           | Object | Y        | null                    |


