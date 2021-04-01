//jquery中定义的页面加载函数(页面加载完成执行)
$(function () {
    //debugger
    doGetNotices();
    //分页事件注册及处理
    //在类选择器为pagination的容器对象注册click事件，
    // 当点击容器内部的pre,next,jump类选择器对应的元素时执行doJumpToPage函数
    $(".pagination").on("click", ".pre,.next,.jump", doJumpToPage);
});

//基于分页按钮点击事件，进行分页查询
function doJumpToPage() {
    debugger
    //1.获取被点击对象的class属性值.
    //$(this)表示被点击的对象
    //prop(属性名[,属性值])为jquery中用于操作属性值的一函数
    let cls = $(this).prop("class");
    //2.基于被点击对象的class属性值修改当前页码值
    //2.1获取当前页码值，总页数
    let pageCurrent = parseInt(localStorage.getItem("pageCurrent"));//当前页码值
    let pageCount = parseInt(localStorage.getItem("pageCount"));//总页数
    //2.2修改当前页码值
    if (cls == "pre" && pageCurrent > 1) {
        pageCurrent--;
    } else if (cls == "next" && pageCurrent < pageCount) {
        pageCurrent++;
    } else if (cls == "jump") {
        //获取form表单中元素为input，名字为pageCurrent的值
        let pageC = parseInt($("form input[name=pageCurrent]").val());
        if (pageC < 1 || pageC > pageCount) {
            alert("页码值不合法");
            $("form input[name=pageCurrent]").val("");//回到初始状态
            return;
        }
        pageCurrent = pageC;
        $("form input[name=pageCurrent]").val("");//回到初始状态
    } else {
        //假如已经是第一页了，你还点上一页，则什么也不做
        //假如已经是最后一页了，你还点下一页，则什么不做
        return;
    }
    console.log("pageCurrent", pageCurrent)
    //将修改了以后的当前页码值，存储起来
    localStorage.setItem("pageCurrent", pageCurrent);
    //3.基于新的页码值重新执行查询
    doGetNotices();

}

//条件查询公告通告信息
function doGetNotices() {
    //定义请求参数
    let pageCurrent = localStorage.getItem("pageCurrent");
    if (!pageCurrent) pageCurrent = 1;
    // let params="pageCurrent="+pageCurrent;
    //let params=`pageCurrent=${pageCurrent}`;
    let params = {pageCurrent: pageCurrent};
    //let params={pageCurrent}
    //定义请求url
    let url = "http://localhost/notice/";
    //基于jquery中的ajax函数向服务端发起异步请求
    //$代表jquery对象
    $.ajax({
        url: url,
        data: params,
        success(result) {//服务端没有抛出异常到客户端时执行此函数，result为服务端响应的结果
            // console.log(result);//JsonResult
            doHandleQueryResponseResult(result);
        }
    })
}

//处理查询响应结果
function doHandleQueryResponseResult(result) {
    if (result.state == 1) {
        doHandleQueryOk(result);
    } else {
        //doHandleQueryError(....);
    }
}

//处理正确的条件查询结果
function doHandleQueryOk(result) {
    //设置tbody中的内容
    doSetTableBodyRows(result.data.list);
    //设置分页信息(初始化分页数据)
    doSetPagination(result);
}

//初始化分页信息
function doSetPagination(result) {
    debugger
    //初始化页面上的分页数据
    let pageCurrent = result.data.pageNum;//当前页码值
    let pageCount = result.data.pages;//总页数
    $(".percent").html(pageCurrent + "/" + pageCount);
    //将当前页码值存储到浏览器的localStorage对象中，便于其它方法后续应用
    localStorage.setItem("pageCurrent", pageCurrent);
    localStorage.setItem("pageCount", pageCount);
}

//设置tbody中的公告或通知信息
function doSetTableBodyRows(records) {//通告信息
    console.log("records", records);
    //1.获取tbody对象，并清空原有内容
    let tBody = $("tbody");//获取tbody对象
    tBody.empty();//清空tbody内容
    //2.迭代records中的内容，并追加到tbody中
    //console.log("records",records);
    //forEach为js中的原生数组函数，item为数组中的一个元素，i为元素下表
    records.forEach((item, i) => tBody.append(doCreateRow(item, i)));
    //迭代方法2
    // records.forEach(function(item,i){
    //     let tr=doCreateRow(item,i);
    //     tBody.append(tr)
    // });
    //迭代方法3
    // for(let i=0;i<records.length;i++){
    //     let tr=doCreateRow(records[i],i);
    //     tBody.append(tr)
    // }
}

//创建tr对象并填写每一列的内容
function doCreateRow(item, i) {
    return `<tr><td>${i + 1}</td>
                    <td>${item.title}</td>
                    <td>${item.type == '1' ? "通知" : "公告"}</td>
                    <td>${item.status == '0' ? "正常" : "关闭"}</td>
                    <td>${item.createdTime}</td>
                    <td>delete</td>
                <tr>`;
}