package top.hermite.repeater.pigeon.core.base.model.dto;

import lombok.Data;

/**
 * MIT License Copyright (c) 2019 HermiteZhang
 *
 * @Author HermiteZhang
 * @Email zhangw9409@gmail.com
 * @Date create in 23:19 2019/9/24
 * @Desc:
 */
@Data
public class PigeonRepeaterPageDto {
    public static final String SORTORDER_ACS = "asc";
    public static final Integer MAX_PAGE_SIZE=3000;
    public static final Integer SHORT_PAGE_SIZE=5;

    /**
     * 当前页
     */
    private Integer page;

    /**
     * 每页显示，默认:10
     */
    private Integer rp = 10;

    /**
     * 总记录数
     */
    private Integer rowCount;

    /**
     * 排序字段
     */
    private String sortName;

    /**
     * 排序(asc/desc)
     */
    private String sortOrder = "desc";



    public PigeonRepeaterPageDto() {
        super();
    }

    public PigeonRepeaterPageDto(Integer page, Integer rp) {
        super();
        this.page = page;
        this.rp = rp;
    }

    public PigeonRepeaterPageDto(Integer page, Integer rp, String sortName) {
        super();
        this.page = page;
        this.rp = rp;
        this.sortName = sortName;
    }

    public PigeonRepeaterPageDto(Integer page, Integer rp, String sortName, String sortOrder) {
        super();
        this.page = page;
        this.rp = rp;
        this.sortName = sortName;
        this.sortOrder = sortOrder;
    }

    public static PigeonRepeaterPageDto createMaxPageDto(){
        PigeonRepeaterPageDto pageDto=new PigeonRepeaterPageDto();
        pageDto.setRp(MAX_PAGE_SIZE);
        pageDto.setPage(1);
        return pageDto;
    }
    public static PigeonRepeaterPageDto generateFlexiPageDto(Integer page, Integer rp, String orderBy) {
        PigeonRepeaterPageDto pageDto = new PigeonRepeaterPageDto(page, rp);
        if (null != orderBy && "" != orderBy.trim()) {
            String[] orderBys = orderBy.split("_");
            pageDto.setSortName(orderBys[0]);
            pageDto.setSortOrder(orderBys[1]);
        }
        return pageDto;
    }
    /**
     * 数据开始坐标，Mysql从0开始
     */
    public Integer getOffset(){
        return (this.getPage()-1)*this.getRp();
    }

    /**
     * 总页数
     */
    public Integer getTotalPage() {
        if (null == rowCount) {
            return 0;
        }
        int totalPage = (rowCount / rp);
        int remainder = rowCount % rp;
        if (rowCount > 0 && totalPage == 0) {
            totalPage = 1;
            return totalPage;
        }
        if (remainder > 0) {
            totalPage++;
            return totalPage;
        }
        return totalPage;
    }


    public String getSortString(){

        if (null == sortName) {
            return null;
        }
        String[] fields = this.getSortName().split("_");
        String[] fieldsorts = this.getSortOrder().split("_");
        if(fields.length!=fieldsorts.length){
            throw new RuntimeException("排序规则不一致");
        }

        String sql = "";
        for(int index=0;index<fields.length;index++){
            sql = sql+" "+fields[index]+" "+fieldsorts[index];
        }

        return sql;
    }
}
