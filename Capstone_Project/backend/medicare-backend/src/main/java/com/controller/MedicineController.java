package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.Medicine;
import com.service.MedicineService;

@RestController
@RequestMapping("Medicine")
@CrossOrigin(origins = "http://localhost:3000")
public class MedicineController {
	
	@Autowired
	MedicineService medicineService;
	
	@PostMapping(value="addMedicine",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String addMedicine(@RequestBody Medicine medicine) {
		return medicineService.createMedicine(medicine);
	}
	
	@GetMapping(value = "viewAllMedicine",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Medicine> getAllMedicines() {
		return medicineService.findAllMedicine();
	}
	

	
    @PutMapping("/{medicineid}")
    public ResponseEntity<String> updateProduct(@PathVariable int medicineid, @RequestBody Medicine updatedMedicine) {
        medicineService.updateProduct(medicineid, updatedMedicine);
        return ResponseEntity.ok("Product updated successfully");
    }

	
    @DeleteMapping("/{medicineid}")
    public ResponseEntity<String> deleteMedicine(@PathVariable int medicineid) {
        medicineService.deleteMedicine(medicineid);
        return ResponseEntity.ok("Medicine deleted successfully");
    }
    
    @GetMapping(value = "searchMedicine")
    public List<Medicine> searchMedicine(@RequestParam String query) {
        return medicineService.searchMedicine(query);
    }
    
    @PutMapping("/enable/{medicineid}")
    public ResponseEntity<String> enableMedicine(@PathVariable int medicineid) {
        String result = medicineService.enableMedicine(medicineid);
        if (result.equals("Medicine enabled")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }
    
    @PutMapping("/disable/{medicineid}")
    public ResponseEntity<String> disableMedicine(@PathVariable int medicineid) {
        String result = medicineService.disableMedicine(medicineid);
        if (result.equals("Medicine disabled")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable int id) {
        Medicine medicine = medicineService.findMedicineById(id);
        if (medicine != null) {
            return new ResponseEntity<>(medicine, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/updateInventory/{medicineId}")
    public ResponseEntity<Medicine> updateInventory(@PathVariable int medicineId, @RequestParam int newInventory) {
        try {
            Medicine updatedMedicine = medicineService.updateInventory(medicineId, newInventory);
            return ResponseEntity.ok(updatedMedicine);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
}


	