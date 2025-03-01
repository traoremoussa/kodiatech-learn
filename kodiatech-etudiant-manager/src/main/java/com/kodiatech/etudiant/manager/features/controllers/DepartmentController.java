package com.kodiatech.etudiant.manager.features.controllers;

import com.kodiatech.etudiant.manager.features.model.Department;
import com.kodiatech.etudiant.manager.features.service.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
/*Controller
@ResponseBody*/
//for rest
@RequestMapping("api/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final IDepartmentService departmentService;


    @GetMapping("/all")
    public ResponseEntity<List<Department>> findAllDepartement() {
        return ResponseEntity.ok().body(departmentService.findAllDepartement());
    }

}
