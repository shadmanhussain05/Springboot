package com.school.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.Services.StudentService;
import com.school.entities.Student;

@RestController
public class StudentController{

	@Autowired
	private StudentService studentService;
	
	// Display The List of Student....
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("ListStudents",studentService.getAllStudets());
		return "index";
	}
	
	@GetMapping("/studentForm")
	public String ShowNewstudentForm(Model model) {
		
		 //Create Model Attribute to bind from Data
		Student student =  new Student();
		model.addAttribute("student", student);
		return "new_student";
	}
	
	// Save Student in to Database.......
	@PostMapping("/saveStudent")
	public  String saveStudent(@ModelAttribute("student") Student student)
	{
	studentService.saveStudent(student);
	return "redirect:/";
		
	}
	
	@GetMapping("/updateStudent/{id}")
	public String FormUpdate(@PathVariable(value="id")long id, Model model ) {
		// get Student from Services.....
		Student student = studentService.getStudentById(id);
		
		// Set studentas a 	model attribute to pre-populate the form

		model.addAttribute("student",student);
		return "upadte_student";
	}
	
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable(value="id") long id) {
		// Call Delete Student method
		this.studentService.deleteStudentById(id);
		return "redirect:/";
	}
}

//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.school.Services.StudentService;
//
//@RestController
//public class StudentController {
//    @Autowired
//    private StudentService studentService;
//
//    @GetMapping("/")
//    public List<Student> getAllStudents() {
//        return studentRepository.findAll();
//    }
//
//    @PostMapping("/")
//    public Student createStudent(@RequestBody Student student) {
//        return studentRepository.save(student);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
//    	Optional<Student> student = studentRepository.findById(id);
//		        if (student.isPresent()) {
//            return ResponseEntity.ok(student.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
//        if (!studentRepository.existsById(id)) {
//            return ResponseEntity.notFound().build();
//        }
//        updatedStudent.setId(id);
//        return ResponseEntity.ok(studentRepository.save(updatedStudent));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
//        if (studentRepository.existsById(id)) {
//            studentRepository.deleteById(id);
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}







/*
 * package com.school.controller;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.school.entities.Student; import
 * com.school.repository.StudentRepository;
 * 
 * import jakarta.persistence.EntityNotFoundException;
 * 
 * @RestController
 * 
 * @RequestMapping("/api/students") public class Studentcontroller {
 * 
 * @Autowired private StudentRepository studentRepository;
 * 
 * @GetMapping public List<Student> getAllStudents() { return
 * studentRepository.findAll(); }
 * 
 * @PostMapping public Student addStudent(@RequestBody Student student) { return
 * studentRepository.save(student); }
 * 
 * @GetMapping("/{id}") public Student getStudentById(@PathVariable Long id) {
 * return studentRepository.findById(id) .orElseThrow(() -> new
 * EntityNotFoundException("Student not found with id: " + id)); }
 * 
 * @PutMapping("/{id}") public Student updateStudent(@PathVariable Long
 * id, @RequestBody Student updatedStudent) { // Implement update logic here }
 * 
 * @DeleteMapping("/{id}") public void deleteStudent(@PathVariable Long id) { //
 * Implement delete logic here } }
 */