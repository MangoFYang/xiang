// json数据解析器, 在返回数据的的分页信息中当前页和总页数必须正确，其余信息jqGrid会经过计算得出
jsonReader : {
	// root描述数据的开始
	root: "content",
	// 当前页号
	page: "number",
	// 总页数: The total number of pages
	total: "totalPages",
	// 总记录数: The total number of records
	records: "totalElements",
	// 设置这个选项为false指示jqGrid在json数据中使用name查询元素, 
	// 这个name来自colModel的name选项或者jsonmap(优先)选项。
	// json数据中, 当repeatitems为false时,
	// colModel的name和jsonmap选项可以使用点标记(item.price)和索引标记(item['price'])
	repeatitems: false,
	// id为行的唯一标识，默认为第一列
	id: "id",
	// 额外信息
	userdata: "userdata"
},
prmNames: {
	// 当前页号
	page: "page.page",
	// 每页记录数
	rows: "page.size",
	// 排序排序属性名
	sort: "page.sort",
	// desc、asc
	order: "page.sort.dir",
	// 通过传入时间(对于IE浏览器不缓存请求)
	nd: 'timestamp'
}