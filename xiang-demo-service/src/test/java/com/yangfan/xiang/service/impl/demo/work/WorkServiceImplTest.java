package com.yangfan.xiang.service.impl.demo.work;

import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yangfan.xiang.model.po.demo.work.Author;
import com.yangfan.xiang.model.po.demo.work.Book;
import com.yangfan.xiang.model.po.demo.work.Song;
import com.yangfan.xiang.model.po.demo.work.Work;
import com.yangfan.xiang.service.iface.demo.work.AuthorService;
import com.yangfan.xiang.service.iface.demo.work.WorkService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-service.xml")
public class WorkServiceImplTest {
	
	@Resource
	private AuthorService authorService;
	
	@Resource
	private WorkService workService;
	
	@Test
	@Transactional
	public void testFindOne() {
		Author a = authorService.findOne("ae79eeb4-ba57-4110-a8d3-9f4fd81d4f83");
		Set<Work> works = a.getWorks();
		for (Work work : works) {
			if(work instanceof Book) {
				System.out.println((Book)work);
			} else if(work instanceof Song) {
				System.out.println((Song)work);
			}
		}
	}

	@Test
	public void testSaveWork() {
		Book b = new Book();
		b.setTitle("书的标题");
		b.setText("书的内容");
		workService.saveWork("ae79eeb4-ba57-4110-a8d3-9f4fd81d4f83", b);
		
		Song s = new Song();
		s.setTitle("歌名");
		s.setGenre("民歌");
		workService.saveWork("ae79eeb4-ba57-4110-a8d3-9f4fd81d4f83", s);
	}

}
