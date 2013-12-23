/*
CREATE TABLE category(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(20) NOT NULL,
	pid INT DEFAULT NULL
);
*/

var nationalpeoplescongressofthecommunistpartyofchina = [
{id: 999999, 	pid: null,		name: "中国共产党全国代表大会",	selectable: false},
{id: 10, 		pid: 999999, 	name: "中央委员会",				selectable: false},
{id: 11, 		pid: 10, 		name: "中央委员会总书记",		selectable: false},
{id: 12, 		pid: 11, 		name: "胡锦涛",					selectable: true},
{id: 13, 		pid: 10,		name: "中央政治局常务委员会",		selectable: false},
{id:14, 		pid: 13,		name: "胡锦涛",					selectable: true},
{id:15, 		pid: 13,		name: "吴邦国",					selectable: true},
{id:16, 		pid: 13,		name: "温家宝",					selectable: true},
{id:17, 		pid: 13,		name: "贾庆林",					selectable: true},
{id:18, 		pid: 13,		name: "李长春",					selectable: true},
{id:19, 		pid: 13,		name: "习近平",					selectable: true},
{id:20, 		pid: 13,		name: "李克强",					selectable: true},
{id:21, 		pid: 13,		name: "贺国强",					selectable: true},
{id:22, 		pid: 13,		name: "周永康",					selectable: true},
{id:23, 		pid: 10,		name: "中央政治局",				selectable: false},
{id:24, 		pid: 23,		name: "中央书记处",				selectable: false},
{id:25, 		pid: 24,		name: "习近平",					selectable: true},
{id:26, 		pid: 24,		name: "刘云山",					selectable: true},
{id:27, 		pid: 24,		name: "李源潮",					selectable: true},
{id:28, 		pid: 24,		name: "何勇",					selectable: true},
{id:29, 		pid: 24,		name: "令计划",					selectable: true},
{id:30, 		pid: 24,		name: "王沪宁",					selectable: true},
{id:31, 		pid: 23,		name: "习近平",					selectable: true},
{id:32, 		pid: 23,		name: "王刚",					selectable: true},
{id:33, 		pid: 23,		name: "王乐泉",					selectable: true},
{id:34, 		pid: 23,		name: "王兆国",					selectable: true},
{id:35, 		pid: 23,		name: "王岐山",					selectable: true},
{id:36, 		pid: 23,		name: "回良玉(回族)",			selectable: true},
{id:37, 		pid: 23,		name: "刘淇",					selectable: true},
{id:38, 		pid: 23,		name: "刘云山",					selectable: true},
{id:39, 		pid: 23,		name: "刘延东(女)",				selectable: true},
{id:40, 		pid: 23,		name: "李长春",					selectable: true},
{id:41, 		pid: 23,		name: "李克强",					selectable: true},
{id:42, 		pid: 23,		name: "李源潮",					selectable: true},
{id:43, 		pid: 23,		name: "吴邦国",					selectable: true},
{id:44, 		pid: 23,		name: "汪洋",					selectable: true},
{id:45, 		pid: 23,		name: "张高丽",					selectable: true},
{id:46, 		pid: 23,		name: "张德江",					selectable: true},
{id:47, 		pid: 23,		name: "周永康",					selectable: true},
{id:48, 		pid: 23,		name: "胡锦涛",					selectable: true},
{id:49, 		pid: 23,		name: "俞正声",					selectable: true},
{id:50, 		pid: 23,		name: "贺国强",					selectable: true},
{id:51, 		pid: 23,		name: "贾庆林",					selectable: true},
{id:52, 		pid: 23,		name: "徐才厚",					selectable: true},
{id:53, 		pid: 23,		name: "郭伯雄",					selectable: true},
{id:54, 		pid: 23,		name: "温家宝",					selectable: true},
{id:55, 		pid: 10,		name: "中央军事委员会",			selectable: false},
{id:56, 		pid: 55,		name: "主席",					selectable: false},
{id:57, 		pid: 56,		name: "胡锦涛",					selectable: true},
{id:58, 		pid: 55,		name: "副主席",					selectable: false},
{id:59, 		pid: 58,		name: "习近平",					selectable: true},
{id:60, 		pid: 58,		name: "郭伯雄",					selectable: true},
{id:61, 		pid: 58,		name: "徐才厚",					selectable: true},
{id:62, 		pid: 55,		name: "委员",					selectable: false},
{id:63, 		pid: 62,		name: "梁光烈",					selectable: true},
{id:64, 		pid: 62,		name: "陈炳德",					selectable: true},
{id:65, 		pid: 62,		name: "李继耐",					selectable: true},
{id:66, 		pid: 62,		name: "廖锡龙",					selectable: true},
{id:67, 		pid: 62,		name: "常万全",					selectable: true},
{id:68, 		pid: 62,		name: "靖志远",					selectable: true},
{id:69, 		pid: 62,		name: "吴胜利",					selectable: true},
{id:70, 		pid: 62,		name: "许其亮",					selectable: true},
{id:71, 		pid: 999999,	name: "中央纪律检查委员会",		selectable: false},
{id:72, 		pid: 71,		name: "书  记",					selectable: false},
{id:73, 		pid: 72,		name: "贺国强",					selectable: true},
{id:74, 		pid: 71,		name: "副书记",					selectable: false},
{id:75, 		pid: 74,		name: "何 勇",					selectable: true},
{id:76, 		pid: 74,		name: "张惠新",					selectable: true},
{id:77, 		pid: 74,		name: "马馼(女)",				selectable: true},
{id:78, 		pid: 74,		name: "孙忠同",					selectable: true},
{id:79, 		pid: 74,		name: "干以胜",					selectable: true},
{id:80, 		pid: 74,		name: "张 毅",					selectable: true},
{id:81, 		pid: 74,		name: "黄树贤",					selectable: true},
{id:82, 		pid: 74,		name: "李玉赋",					selectable: true},
{id:83, 		pid: 74,		name: "吴玉良",					selectable: true},
{id:84, 		pid: 71,		name: "常务委员会委员",			selectable: false},
{id:85, 		pid: 84,		name: "干以胜",					selectable: true},
{id:86, 		pid: 84,		name: "马馼(女)",				selectable: true},
{id:87, 		pid: 84,		name: "王伟",					selectable: true},
{id:88, 		pid: 84,		name: "令狐安",					selectable: true},
{id:89, 		pid: 84,		name: "孙忠同",					selectable: true},
{id:90, 		pid: 84,		name: "杜学芳(女)",				selectable: true},
{id:91, 		pid: 84,		name: "李玉赋",					selectable: true},
{id:92, 		pid: 84,		name: "吴玉良",					selectable: true},
{id:93, 		pid: 84,		name: "吴毓萍(女)",				selectable: true},
{id:94, 		pid: 84,		name: "邱学强",					selectable: true},
{id:95, 		pid: 84,		name: "何勇",					selectable: true},
{id:96, 		pid: 84,		name: "张军",					selectable: true},
{id:97, 		pid: 84,		name: "张毅",					selectable: true},
{id:98, 		pid: 84,		name: "张纪南",					selectable: true},
{id:99, 		pid: 84,		name: "张惠新",					selectable: true},
{id:100, 		pid: 84,		name: "屈万祥",					selectable: true},
{id:101, 		pid: 84,		name: "贺国强",					selectable: true},
{id:102, 		pid: 84,		name: "黄树贤",					selectable: true},
{id:103, 		pid: 84,		name: "蔡继华",					selectable: true},
];

/*
function adjacencyAdapter(data) {
	return buildTree(treeDataAdjacency);
}

function buildTree(data) {
	var tree = [], roots = findRoots(data);
	$.each(roots, function(i, n) {
		var o = normalizeNode(n);
		fillChildren(o, data);
		tree.push(o);
	});
	return tree;
}

function fillChildren(parent, data) {
	$.each(data, function(i, n) {
		if (n.pid === parent.attr.id) {
			var o = normalizeNode(n);
			if (!parent.children) {
				parent.children = [];
			}
			parent.children.push(o);
			fillChildren(o, data);
		}
	});
}

function normalizeNode(n) {
	return {
		attr : {
			id : n.id,
			selectable : n.selectable
		},
		metadata : n,
		data : {
			title : n.name,
			// a
			attr : {
				id : n.id + "-a",
				href : "javascript:void(0)"
			}
		}
	};
}

function findRoots(data) {
	var roots = [];
	$.each(data, function(i, n) {
		if (n.pid === null) {
			roots.push(n);
		}
	});
	return roots;
}
*/
