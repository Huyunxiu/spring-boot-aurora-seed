package ${package.Controller};

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${cfg.parentPackage}.core.Result;
import ${package.Entity}.${entity};
import ${cfg.parentPackage}.model.BasePaginationParams;
import ${package.Service}.${table.serviceName};
<#if swagger2>
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
</#if>
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

import javax.annotation.Resource;

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if swagger2>
@Api(value = "/v1/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}s<#else>${table.entityPath}</#if>", description = "${entity} feature")
</#if>
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("/v1/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}s<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {

</#if>
    @Resource
    private ${table.serviceName} ${table.serviceName ? uncap_first};

    @PostMapping
    <#if swagger2>
    @ApiOperation(value = "Add ${controllerMappingHyphen}")
    </#if>
    public Result<${entity}> add(@RequestBody ${entity} record) {
        ${table.serviceName ? uncap_first}.save(record);
        return Result.success(record);
    }

    @DeleteMapping("/{id}")
    <#if swagger2>
    @ApiOperation(value = "Delete ${controllerMappingHyphen}")
    </#if>
    public Result delete(@PathVariable Integer id) {
        ${table.serviceName ? uncap_first}.removeById(id);
        return Result.success();
    }

    @PutMapping("/{id}")
    <#if swagger2>
    @ApiOperation(value = "Update ${controllerMappingHyphen}")
    </#if>
    public Result<${entity}> update(@PathVariable Integer id, @RequestBody ${entity} record) {
        record.setId(id);
        ${table.serviceName ? uncap_first}.updateById(record);
        return Result.success(record);
    }

    @GetMapping("/{id}")
    <#if swagger2>
    @ApiOperation(value = "Get ${controllerMappingHyphen}")
    </#if>
    public Result<${entity}> get(@PathVariable Integer id) {
        ${entity} record = ${table.serviceName ? uncap_first}.getById(id);
        return Result.success(record);
    }

    @GetMapping
    <#if swagger2>
    @ApiOperation(value = "List ${controllerMappingHyphen}")
    </#if>
    public Result<IPage<${entity}>> list(@Validated BasePaginationParams params) {
        Page<${entity}> page = new Page<>(params.getPageNumber(), params.getPageSize());
        IPage<${entity}> pageInfo = ${table.serviceName ? uncap_first}.page(page);
        return Result.success(pageInfo);
    }
}
</#if>
