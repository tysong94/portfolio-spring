package kr.ac.kopo.board.web.resort;
//package kr.ac.kopo.board.web.gongji;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import kr.ac.kopo.board.domain.Reservation;
//import kr.ac.kopo.board.service.GongjiService;
//
//@RestController
//public class ReservationRestController {
//	
//	private static final Logger logger = LoggerFactory.getLogger(ReservationRestController.class);
//	
//	@Autowired
//	private GongjiService gongjiService;
//	
//    //-------------------Retrieve Single Gongji--------------------------------------------------------
//    public ResponseEntity<Reservation> getGongji(int id) {
//    	logger.info("Fetching User with id " + id);
//        Reservation gongji = gongjiService.selectOne(id);
//        if (gongji == null) {
//        	logger.info("Gongji with id " + id + " not found");
//            return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<Reservation>(gongji, HttpStatus.OK);
//    }
// 
//    
//    //-------------------Xml--------------------------------------------------------
//    @RequestMapping(value = "/api/gongji/one/xml/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Reservation> getGongjiXml(@PathVariable("id") int id) {
//    	return getGongji(id);
//    }
//
//    //-------------------json--------------------------------------------------------
//    @RequestMapping(value = "/api/gongji/one/json/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Reservation> getGongjiJson(@PathVariable("id") int id) {
//    	return getGongji(id);
//    }
//     
//}
