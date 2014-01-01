package com.yangfan.xiang.service.impl.demo.work;

import org.springframework.stereotype.Service;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.service.support.CoreServiceSupport;
import com.yangfan.xiang.model.po.demo.work.Song;
import com.yangfan.xiang.persist.repository.demo.work.SongRepository;
import com.yangfan.xiang.service.iface.demo.work.SongService;

@Service
public class SongServiceImpl extends CoreServiceSupport<Song, String> implements SongService {
	
	private SongRepository songRepository;

	@Override
	protected CoreRepository<Song, String> getRepository() {
		return songRepository;
	}

}
