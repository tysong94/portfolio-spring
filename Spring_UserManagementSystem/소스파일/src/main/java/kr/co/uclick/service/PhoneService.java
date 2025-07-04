package kr.co.uclick.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.uclick.entity.Phone;
import kr.co.uclick.entity.Phone;
import kr.co.uclick.repository.PhoneRepository;

@Service
@Transactional
public class PhoneService {

	@Autowired
	private PhoneRepository phoneRepository;

	//READ---------------------------------------------
	@Cacheable(value = "area")
	@Transactional(readOnly = true)
	public List<Phone> findByNumberContaining(String number) {
		return phoneRepository.findByNumberContaining(number);
	}

	@Cacheable(value = "area")
	@Transactional(readOnly = true)
	public Phone findById(Long id) {
		Optional<Phone> phone = phoneRepository.findById(id);
		return phone.get();
	}
	
	@Cacheable(value = "area")
	@Transactional(readOnly = true)
	public Phone findByNumber(String number) {
		return phoneRepository.findByNumber(number);
	}
	
	//CREATE, UPDATE-------------------------------------
	@CacheEvict(value = "area", allEntries = true)
	public Phone save(Phone p) {
		return phoneRepository.save(p);
	}

	//DELETE----------------------------------------------
	@CacheEvict(value = "area", allEntries = true)
	public void delete(Phone entity) {
		phoneRepository.delete(entity);
	}
}
