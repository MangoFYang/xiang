package com.yangfan.xiang.core.tools.statisticsjavacode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 统计Java代码，空行、注释行、代码行。
 * 
 * @author 杨帆
 *
 */
public class StatisticsJavaCode {
	
	private static final String SRC_DIR = "D:/soft/eclipse/myeclipse/MyEclipse 10/Workspaces/MyEclipse 10/xiang/xiang-core/src/main/java/com/yangfan/xiang/core/tools/twodbSyncrecord";

	private static long normalLines = 0; // 空行
	private static long commentLines = 0; // 注释行
	private static long whiteLines = 0; // 代码行

	public static void main(String[] args) {
		StatisticsJavaCode sjc = new StatisticsJavaCode();
		File f = new File(SRC_DIR);
		System.out.println(f);
		sjc.treeFile(f);

		System.out.println("总行数：" + (normalLines + commentLines + whiteLines));
		System.out.println("空行数：" + whiteLines);
		System.out.println("注释行数：" + commentLines);
		System.out.println("有效代码行数：" + normalLines);
	}

	/**
	 * 查找出一个目录下所有的.java文件
	 * 
	 * @param f
	 *            要查找的目录
	 */
	private void treeFile(File f) {

		File[] childs = f.listFiles();
		// int count = 0;
		// int sum = 0;
		for (int i = 0; i < childs.length; i++) {
			// System.out.println(preStr + childs[i].getName());
			if (!childs[i].isDirectory()) {
				if (childs[i].getName().endsWith(".java")) {
					sumCode(childs[i]);
				}
			} else {
				treeFile(childs[i]);
				// sum += count;
			}
		}
	}

	/**
	 * 计算一个.java文件中的代码行，空行，注释行
	 * 
	 * @param file
	 *            要计算的.java文件
	 */
	private void sumCode(File file) {
		BufferedReader br = null;
		boolean comment = false;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			try {
				while ((line = br.readLine()) != null) {
					line = line.trim();
					if (line.length() == 0) {
						whiteLines++;
					} else if (line.startsWith("//")) {
						commentLines++;
					} else if (line.startsWith("/*") && line.endsWith("*/")) {
						commentLines++;
					} else if (line.startsWith("/*") && !line.endsWith("*/")) {
						commentLines++;
						comment = true;
					} else if (true == comment) {
						commentLines++;
						if (line.endsWith("*/")) {
							comment = false;
						}
					} else {
						normalLines++;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
					br = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

/* */

