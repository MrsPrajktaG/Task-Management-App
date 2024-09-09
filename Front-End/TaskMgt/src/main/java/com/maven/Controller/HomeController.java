package com.maven.Controller;

import com.maven.Model.*;
import com.maven.Services.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@CrossOrigin("*")
@RequestMapping("/taskmgt")
public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private MailService mailService;
    @Autowired
    private DesignationsService designationsService;
    @Autowired
    private AdminGroupsService adminGroupsService;
    @Autowired
    private PermissionService permissionService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        Long id = user.getAdminGroups().getId();
        AdminGroups groupById = adminGroupsService.getGroupById(id);
        user.setAdminGroups(groupById);
        return userService.addUser(user);
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.GetAllUser();
    }

    @PostMapping("/addGroup")
    public AdminGroups createGroup(@RequestBody AdminGroups adminGroups){

        AdminGroups group = adminGroupsService.createGroup(adminGroups);
        Set<String> module_list = new HashSet<>();
        module_list.add("Admin");
        module_list.add("Admin Groups");
        module_list.add("Designations");
        module_list.add("Members");
        module_list.add("Categories");
        module_list.add("Project");
        module_list.add("Task");
        module_list.add("Productivities");
        module_list.add("Reports");
        module_list.add("Settings");
        module_list.forEach(m->{
            UserPermission p = new UserPermission();
            p.setModules(m);
            p.setShowPermission(Boolean.FALSE);
            p.setCreatePermission(Boolean.FALSE);
            p.setEditPermission(Boolean.FALSE);
            p.setDeletePermission(Boolean.FALSE);
            p.setAdminGroups(group);
            permissionService.setPermissions(p);
        });
        return group;
    }

    @GetMapping("/getGroupById/{id}")
    public AdminGroups getGroup(@PathVariable Long id){
        return adminGroupsService.getGroupById(id);
    }

    @PostMapping("/addPermissions")
    public UserPermission setPermissions(@RequestBody UserPermission permission){
        return permissionService.setPermissions(permission);
    }

    @GetMapping("/getPermissionById/{id}")
    public List<UserPermission> getAllPermissions(@PathVariable Long id){
        return permissionService.getAllPermissionsByGroupId(id);
    }

    @PutMapping("/updatePermissions/{gid}")
    public UserPermission updatePermission(@PathVariable Long gid, @RequestBody UserPermission userPermission){
        System.out.println(gid);
        System.out.println(userPermission.toString());
        UserPermission permission = permissionService.updatePermissionsByAdminGroupIdAndPermissionId(gid, userPermission);

        return null;
    }

    @PostMapping("/login")
    public User login(@RequestBody User user){
        return userService.login(user);
    }

    @PostMapping("/addcategories")
    public Categories addcategories(@RequestBody Categories categories){
        return categoriesService.addcategories(categories);
    }

    @GetMapping("/getAllCategories")
    public List<Categories> getAllCategories(){
        return categoriesService.getAllCategories();
    }

    @PostMapping("/addprojects")
    public Projects addprojects(@RequestBody Projects projects){
        return projectService.addprojects(projects);
    }

    @PostMapping("/sendMail")
    public void addprojects(@RequestBody Mail mail){
         mailService.sendMail(mail);
    }
    @PostMapping("/adddesignations")
    public Designations adddesignations(@RequestBody Designations designations){
        return designationsService.adddesignations(designations);
    }

    @PostConstruct
    public void createAdmin(){
        User user=new User();
        user.setId(1L);
        user.setFirstname("Super");
        user.setLastname("Admin");
        user.setEmail("superadmin@gmail.com");
        user.setPhone("7058613500");
        user.setPassword("superadmin123");
        user.setImage("img");
        AdminGroups g = new AdminGroups();
        g.setId(1L);
        g.setGroup_name("SUPER_ADMIN");
        g.setDescription(("This is super admin group"));
        AdminGroups group = adminGroupsService.createGroup(g);
        user.setAdminGroups(group);
        Set<String> module_list = new HashSet<>();
        module_list.add("Admin");
        module_list.add("Admin Groups");
        module_list.add("Designations");
        module_list.add("Members");
        module_list.add("Categories");
        module_list.add("Project");
        module_list.add("Task");
        module_list.add("Productivities");
        module_list.add("Reports");
        module_list.add("Settings");
        final int[] id = {0};
        module_list.forEach(m->{
            id[0] += 1;
            UserPermission p = new UserPermission();
            p.setId(id[0]);
            p.setModules(m);
            p.setShowPermission(Boolean.TRUE);
            p.setCreatePermission(Boolean.TRUE);
            p.setEditPermission(Boolean.TRUE);
            p.setDeletePermission(Boolean.TRUE);
            p.setAdminGroups(group);
            permissionService.setPermissions(p);
        });

        userService.addUser(user);

    }


//    ----------------- All Group Operations ------------------------

    @GetMapping("/allGroups")
    public Set<AdminGroups> getAllGroup(){
        return adminGroupsService.getAllGroups();
    }

}
