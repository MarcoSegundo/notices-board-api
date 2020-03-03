package com.marco.noticesboardapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marco.noticesboardapi.controller.dto.NoticeDTO;
import com.marco.noticesboardapi.service.NoticeService;

@RestController
@RequestMapping({"/notices"})
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping
	public ResponseEntity<List<NoticeDTO>> getAll(){
		List<NoticeDTO> noticesDTO = noticeService.getAll();
		return ResponseEntity.ok(noticesDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<NoticeDTO> getById(@PathVariable Long id){
		NoticeDTO noticeDTO = noticeService.getById(id);
		
		return noticeDTO != null ? ResponseEntity.ok().body(noticeDTO)
				: ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<NoticeDTO> create(@RequestBody NoticeDTO notice){
		notice = noticeService.create(notice);
		return ResponseEntity.ok().body(notice);
	}
	
	@PutMapping
	public ResponseEntity<Void> update(@RequestBody NoticeDTO notice){
		boolean wasUpdated = noticeService.update(notice);
		return wasUpdated ? ResponseEntity.ok().build()
				: ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		boolean wasDeleted = noticeService.delete(id);
		return wasDeleted ? ResponseEntity.ok().build() 
				: ResponseEntity.notFound().build(); 
	}
	
	@PutMapping("/view/{id}")
	public ResponseEntity<Void> view(@PathVariable Long id){
		boolean wasvisualizated = noticeService.viewById(id);
		return wasvisualizated ? ResponseEntity.ok().build()
				: ResponseEntity.notFound().build();
	}
}
