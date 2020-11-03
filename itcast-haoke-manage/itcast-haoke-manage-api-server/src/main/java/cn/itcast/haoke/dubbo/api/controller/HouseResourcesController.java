package cn.itcast.haoke.dubbo.api.controller;

import cn.itcast.haoke.dubbo.api.service.HouseResourcesService;
import cn.itcast.haoke.dubbo.server.pojo.HouseResources;
import cn.itcast.haoke.dubbo.server.pojo.PageInfo;
import cn.itcast.haoke.dubbo.server.vo.HouseResourcesInputVo;
import cn.itcast.haoke.houseResources.response.TableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("house/resources")
public class HouseResourcesController {

    @Autowired
    private HouseResourcesService houseResourcesService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody HouseResources houseResources){
        boolean save = houseResourcesService.save(houseResources);
        if (save)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<Void> update(@RequestBody HouseResources houseResources) {
        try {
            boolean bool = this.houseResourcesService.update(houseResources);
            if (bool) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping
    public ResponseEntity<String> get(){
        return ResponseEntity.ok("sc");
    }

    @GetMapping("/list")
    public ResponseEntity<TableResult> list(
                HouseResourcesInputVo params,
                @RequestParam(value = "currentPage",defaultValue = "1") Integer pageNum,
                @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize ){
        return ResponseEntity.ok(houseResourcesService.list(params,pageNum,pageSize));
    }
}
