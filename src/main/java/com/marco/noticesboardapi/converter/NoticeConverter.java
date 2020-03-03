package com.marco.noticesboardapi.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.marco.noticesboardapi.controller.dto.NoticeDTO;
import com.marco.noticesboardapi.model.Notice;

public class NoticeConverter {
	
	public static Notice fromDTO(NoticeDTO noticeDTO) {
		Notice notice = new Notice();
		
		notice.setId(noticeDTO.getId());
		notice.setTitle(noticeDTO.getTitle());
		notice.setDescription(noticeDTO.getDescription());
		notice.setPublicationDate(noticeDTO.getPublicationDate());
		notice.setVisualizationDate(noticeDTO.getVisualizationDate());
		
		return notice;
	}
	
	public static NoticeDTO toDTO(Notice notice) {
		NoticeDTO noticeDTO = new NoticeDTO();
		
		noticeDTO.setId(notice.getId());
		noticeDTO.setTitle(notice.getTitle());
		noticeDTO.setDescription(notice.getDescription());
		noticeDTO.setPublicationDate(notice.getPublicationDate());
		noticeDTO.setVisualizationDate(notice.getVisualizationDate());
		
		return noticeDTO;
	}
	
	public static List<NoticeDTO> toListDTO(List<Notice> notices){
		List<NoticeDTO> noticesDTO = notices.stream().map(notice -> {
			return toDTO(notice);
		}).collect(Collectors.toList());
		
		return noticesDTO;
	}
}
