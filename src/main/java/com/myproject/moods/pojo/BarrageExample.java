package com.myproject.moods.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BarrageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BarrageExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andBarIdIsNull() {
            addCriterion("bar_id is null");
            return (Criteria) this;
        }

        public Criteria andBarIdIsNotNull() {
            addCriterion("bar_id is not null");
            return (Criteria) this;
        }

        public Criteria andBarIdEqualTo(Long value) {
            addCriterion("bar_id =", value, "barId");
            return (Criteria) this;
        }

        public Criteria andBarIdNotEqualTo(Long value) {
            addCriterion("bar_id <>", value, "barId");
            return (Criteria) this;
        }

        public Criteria andBarIdGreaterThan(Long value) {
            addCriterion("bar_id >", value, "barId");
            return (Criteria) this;
        }

        public Criteria andBarIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bar_id >=", value, "barId");
            return (Criteria) this;
        }

        public Criteria andBarIdLessThan(Long value) {
            addCriterion("bar_id <", value, "barId");
            return (Criteria) this;
        }

        public Criteria andBarIdLessThanOrEqualTo(Long value) {
            addCriterion("bar_id <=", value, "barId");
            return (Criteria) this;
        }

        public Criteria andBarIdIn(List<Long> values) {
            addCriterion("bar_id in", values, "barId");
            return (Criteria) this;
        }

        public Criteria andBarIdNotIn(List<Long> values) {
            addCriterion("bar_id not in", values, "barId");
            return (Criteria) this;
        }

        public Criteria andBarIdBetween(Long value1, Long value2) {
            addCriterion("bar_id between", value1, value2, "barId");
            return (Criteria) this;
        }

        public Criteria andBarIdNotBetween(Long value1, Long value2) {
            addCriterion("bar_id not between", value1, value2, "barId");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andExtimeIsNull() {
            addCriterion("extime is null");
            return (Criteria) this;
        }

        public Criteria andExtimeIsNotNull() {
            addCriterion("extime is not null");
            return (Criteria) this;
        }

        public Criteria andExtimeEqualTo(Date value) {
            addCriterionForJDBCDate("extime =", value, "extime");
            return (Criteria) this;
        }

        public Criteria andExtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("extime <>", value, "extime");
            return (Criteria) this;
        }

        public Criteria andExtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("extime >", value, "extime");
            return (Criteria) this;
        }

        public Criteria andExtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("extime >=", value, "extime");
            return (Criteria) this;
        }

        public Criteria andExtimeLessThan(Date value) {
            addCriterionForJDBCDate("extime <", value, "extime");
            return (Criteria) this;
        }

        public Criteria andExtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("extime <=", value, "extime");
            return (Criteria) this;
        }

        public Criteria andExtimeIn(List<Date> values) {
            addCriterionForJDBCDate("extime in", values, "extime");
            return (Criteria) this;
        }

        public Criteria andExtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("extime not in", values, "extime");
            return (Criteria) this;
        }

        public Criteria andExtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("extime between", value1, value2, "extime");
            return (Criteria) this;
        }

        public Criteria andExtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("extime not between", value1, value2, "extime");
            return (Criteria) this;
        }

        public Criteria andRuntimeIsNull() {
            addCriterion("runtime is null");
            return (Criteria) this;
        }

        public Criteria andRuntimeIsNotNull() {
            addCriterion("runtime is not null");
            return (Criteria) this;
        }

        public Criteria andRuntimeEqualTo(String value) {
            addCriterion("runtime =", value, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeNotEqualTo(String value) {
            addCriterion("runtime <>", value, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeGreaterThan(String value) {
            addCriterion("runtime >", value, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeGreaterThanOrEqualTo(String value) {
            addCriterion("runtime >=", value, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeLessThan(String value) {
            addCriterion("runtime <", value, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeLessThanOrEqualTo(String value) {
            addCriterion("runtime <=", value, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeLike(String value) {
            addCriterion("runtime like", value, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeNotLike(String value) {
            addCriterion("runtime not like", value, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeIn(List<String> values) {
            addCriterion("runtime in", values, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeNotIn(List<String> values) {
            addCriterion("runtime not in", values, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeBetween(String value1, String value2) {
            addCriterion("runtime between", value1, value2, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeNotBetween(String value1, String value2) {
            addCriterion("runtime not between", value1, value2, "runtime");
            return (Criteria) this;
        }

        public Criteria andGoodnumIsNull() {
            addCriterion("goodnum is null");
            return (Criteria) this;
        }

        public Criteria andGoodnumIsNotNull() {
            addCriterion("goodnum is not null");
            return (Criteria) this;
        }

        public Criteria andGoodnumEqualTo(Byte value) {
            addCriterion("goodnum =", value, "goodnum");
            return (Criteria) this;
        }

        public Criteria andGoodnumNotEqualTo(Byte value) {
            addCriterion("goodnum <>", value, "goodnum");
            return (Criteria) this;
        }

        public Criteria andGoodnumGreaterThan(Byte value) {
            addCriterion("goodnum >", value, "goodnum");
            return (Criteria) this;
        }

        public Criteria andGoodnumGreaterThanOrEqualTo(Byte value) {
            addCriterion("goodnum >=", value, "goodnum");
            return (Criteria) this;
        }

        public Criteria andGoodnumLessThan(Byte value) {
            addCriterion("goodnum <", value, "goodnum");
            return (Criteria) this;
        }

        public Criteria andGoodnumLessThanOrEqualTo(Byte value) {
            addCriterion("goodnum <=", value, "goodnum");
            return (Criteria) this;
        }

        public Criteria andGoodnumIn(List<Byte> values) {
            addCriterion("goodnum in", values, "goodnum");
            return (Criteria) this;
        }

        public Criteria andGoodnumNotIn(List<Byte> values) {
            addCriterion("goodnum not in", values, "goodnum");
            return (Criteria) this;
        }

        public Criteria andGoodnumBetween(Byte value1, Byte value2) {
            addCriterion("goodnum between", value1, value2, "goodnum");
            return (Criteria) this;
        }

        public Criteria andGoodnumNotBetween(Byte value1, Byte value2) {
            addCriterion("goodnum not between", value1, value2, "goodnum");
            return (Criteria) this;
        }

        public Criteria andContextsIsNull() {
            addCriterion("contexts is null");
            return (Criteria) this;
        }

        public Criteria andContextsIsNotNull() {
            addCriterion("contexts is not null");
            return (Criteria) this;
        }

        public Criteria andContextsEqualTo(String value) {
            addCriterion("contexts =", value, "contexts");
            return (Criteria) this;
        }

        public Criteria andContextsNotEqualTo(String value) {
            addCriterion("contexts <>", value, "contexts");
            return (Criteria) this;
        }

        public Criteria andContextsGreaterThan(String value) {
            addCriterion("contexts >", value, "contexts");
            return (Criteria) this;
        }

        public Criteria andContextsGreaterThanOrEqualTo(String value) {
            addCriterion("contexts >=", value, "contexts");
            return (Criteria) this;
        }

        public Criteria andContextsLessThan(String value) {
            addCriterion("contexts <", value, "contexts");
            return (Criteria) this;
        }

        public Criteria andContextsLessThanOrEqualTo(String value) {
            addCriterion("contexts <=", value, "contexts");
            return (Criteria) this;
        }

        public Criteria andContextsLike(String value) {
            addCriterion("contexts like", value, "contexts");
            return (Criteria) this;
        }

        public Criteria andContextsNotLike(String value) {
            addCriterion("contexts not like", value, "contexts");
            return (Criteria) this;
        }

        public Criteria andContextsIn(List<String> values) {
            addCriterion("contexts in", values, "contexts");
            return (Criteria) this;
        }

        public Criteria andContextsNotIn(List<String> values) {
            addCriterion("contexts not in", values, "contexts");
            return (Criteria) this;
        }

        public Criteria andContextsBetween(String value1, String value2) {
            addCriterion("contexts between", value1, value2, "contexts");
            return (Criteria) this;
        }

        public Criteria andContextsNotBetween(String value1, String value2) {
            addCriterion("contexts not between", value1, value2, "contexts");
            return (Criteria) this;
        }

        public Criteria andFontsizeIsNull() {
            addCriterion("fontsize is null");
            return (Criteria) this;
        }

        public Criteria andFontsizeIsNotNull() {
            addCriterion("fontsize is not null");
            return (Criteria) this;
        }

        public Criteria andFontsizeEqualTo(Byte value) {
            addCriterion("fontsize =", value, "fontsize");
            return (Criteria) this;
        }

        public Criteria andFontsizeNotEqualTo(Byte value) {
            addCriterion("fontsize <>", value, "fontsize");
            return (Criteria) this;
        }

        public Criteria andFontsizeGreaterThan(Byte value) {
            addCriterion("fontsize >", value, "fontsize");
            return (Criteria) this;
        }

        public Criteria andFontsizeGreaterThanOrEqualTo(Byte value) {
            addCriterion("fontsize >=", value, "fontsize");
            return (Criteria) this;
        }

        public Criteria andFontsizeLessThan(Byte value) {
            addCriterion("fontsize <", value, "fontsize");
            return (Criteria) this;
        }

        public Criteria andFontsizeLessThanOrEqualTo(Byte value) {
            addCriterion("fontsize <=", value, "fontsize");
            return (Criteria) this;
        }

        public Criteria andFontsizeIn(List<Byte> values) {
            addCriterion("fontsize in", values, "fontsize");
            return (Criteria) this;
        }

        public Criteria andFontsizeNotIn(List<Byte> values) {
            addCriterion("fontsize not in", values, "fontsize");
            return (Criteria) this;
        }

        public Criteria andFontsizeBetween(Byte value1, Byte value2) {
            addCriterion("fontsize between", value1, value2, "fontsize");
            return (Criteria) this;
        }

        public Criteria andFontsizeNotBetween(Byte value1, Byte value2) {
            addCriterion("fontsize not between", value1, value2, "fontsize");
            return (Criteria) this;
        }

        public Criteria andSpeedIsNull() {
            addCriterion("speed is null");
            return (Criteria) this;
        }

        public Criteria andSpeedIsNotNull() {
            addCriterion("speed is not null");
            return (Criteria) this;
        }

        public Criteria andSpeedEqualTo(Byte value) {
            addCriterion("speed =", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotEqualTo(Byte value) {
            addCriterion("speed <>", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedGreaterThan(Byte value) {
            addCriterion("speed >", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedGreaterThanOrEqualTo(Byte value) {
            addCriterion("speed >=", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLessThan(Byte value) {
            addCriterion("speed <", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLessThanOrEqualTo(Byte value) {
            addCriterion("speed <=", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedIn(List<Byte> values) {
            addCriterion("speed in", values, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotIn(List<Byte> values) {
            addCriterion("speed not in", values, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedBetween(Byte value1, Byte value2) {
            addCriterion("speed between", value1, value2, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotBetween(Byte value1, Byte value2) {
            addCriterion("speed not between", value1, value2, "speed");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("color is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("color is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("color like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("color not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("color not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andVarIsNull() {
            addCriterion("var is null");
            return (Criteria) this;
        }

        public Criteria andVarIsNotNull() {
            addCriterion("var is not null");
            return (Criteria) this;
        }

        public Criteria andVarEqualTo(String value) {
            addCriterion("var =", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarNotEqualTo(String value) {
            addCriterion("var <>", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarGreaterThan(String value) {
            addCriterion("var >", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarGreaterThanOrEqualTo(String value) {
            addCriterion("var >=", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarLessThan(String value) {
            addCriterion("var <", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarLessThanOrEqualTo(String value) {
            addCriterion("var <=", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarLike(String value) {
            addCriterion("var like", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarNotLike(String value) {
            addCriterion("var not like", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarIn(List<String> values) {
            addCriterion("var in", values, "var");
            return (Criteria) this;
        }

        public Criteria andVarNotIn(List<String> values) {
            addCriterion("var not in", values, "var");
            return (Criteria) this;
        }

        public Criteria andVarBetween(String value1, String value2) {
            addCriterion("var between", value1, value2, "var");
            return (Criteria) this;
        }

        public Criteria andVarNotBetween(String value1, String value2) {
            addCriterion("var not between", value1, value2, "var");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}