package com.marco.noticesboardapi.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marco.noticesboardapi.controller.dto.NoticeDTO;
import com.marco.noticesboardapi.converter.NoticeConverter;
import com.marco.noticesboardapi.model.Notice;
import com.marco.noticesboardapi.repository.NoticeRepository;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeRepository noticeRepository;
	
	
	public List<NoticeDTO> getAll(){
		List<Notice> notices = noticeRepository.findAll();
		List<NoticeDTO> noticesDTO = NoticeConverter.toListDTO(notices);
		
		return noticesDTO;
	}
	
	@Transactional
	public NoticeDTO viewById(long id) {
		if(id != 0L) {
			Optional<Notice> noticeOptional = noticeRepository.findById(id);
			
			if(noticeOptional.isPresent()) {
				Notice notice = noticeOptional.get();
				
				if(notice.getVisualizationDate() == null) {
					notice.setVisualizationDate(LocalDateTime.now());
					notice = noticeRepository.save(notice);
				};
				
				NoticeDTO noticeDTO = NoticeConverter.toDTO(notice);

				return noticeDTO;		
			} 
		}
		
		return null;
	}
	
	public NoticeDTO create(NoticeDTO noticeDTO) {
		noticeDTO.setPublicationDate(LocalDateTime.now());
		
		Notice notice = NoticeConverter.fromDTO(noticeDTO);
		notice = noticeRepository.save(notice);
		
		noticeDTO.setId(notice.getId());
		return noticeDTO;
	}
	
	@Transactional
	public boolean update(NoticeDTO noticeDTO) {
		boolean wasUpdated = false;
		
		if(noticeDTO.getId() != 0L) {
			Optional<Notice> noticeOptional = noticeRepository.findById(noticeDTO.getId());
			
			if(noticeOptional.isPresent()) {
				Notice notice = noticeOptional.get();
				notice.setTitle(noticeDTO.getTitle());
				notice.setDescription(noticeDTO.getDescription());
				noticeRepository.save(notice);
				wasUpdated = true;
			} 
		}
		return wasUpdated;
	}
	
	@Transactional
	public boolean delete(Long id) {
		boolean wasDeleted = false;
		
		if(id != 0L) {
			noticeRepository.deleteById(id);
			wasDeleted = true;
		}
		
		return wasDeleted;
	}
}
