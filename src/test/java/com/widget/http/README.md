### okhttp 与 apache http
*   同样是文件上传,使用okhttp的MultipartBody post请求，发现上传成功的文件只能下载，不能预览。
而apache http 上传成功后访问则是预览。
*   根本原因上传方式的不同。详细可见okhttp的MediaType与apache http 的multipartMode
*   使用MediaType，其默认使用Content-Disposition: inline;
*   ResponseHeader 中的 inline与attachment都是默认作为附件下载使用
*   Content-Disposition: form-data 会将response作为页面的一部分，直接显示。
