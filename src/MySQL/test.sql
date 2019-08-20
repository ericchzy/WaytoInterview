# MySQL习题 原地址: https://www.jianshu.com/p/e6a25cfbd330

# Initialation
create table Student(Sid varchar(6), Sname varchar(10), Sage datetime, Ssex varchar(10));
insert into Student values('01' , '赵雷' , '1990-01-01' , '男');
insert into Student values('02' , '钱电' , '1990-12-21' , '男');
insert into Student values('03' , '孙风' , '1990-05-20' , '男');
insert into Student values('04' , '李云' , '1990-08-06' , '男');
insert into Student values('05' , '周梅' , '1991-12-01' , '女');
insert into Student values('06' , '吴兰' , '1992-03-01' , '女');
insert into Student values('07' , '郑竹' , '1989-07-01' , '女');
insert into Student values('08' , '王菊' , '1990-01-20' , '女');


create table SC(Sid varchar(10), Cid varchar(10), score decimal(18,1));
insert into SC values('01' , '01' , 80);
insert into SC values('01' , '02' , 90);
insert into SC values('01' , '03' , 99);
insert into SC values('02' , '01' , 70);
insert into SC values('02' , '02' , 60);
insert into SC values('02' , '03' , 80);
insert into SC values('03' , '01' , 80);
insert into SC values('03' , '02' , 80);
insert into SC values('03' , '03' , 80);
insert into SC values('04' , '01' , 50);
insert into SC values('04' , '02' , 30);
insert into SC values('04' , '03' , 20);
insert into SC values('05' , '01' , 76);
insert into SC values('05' , '02' , 87);
insert into SC values('06' , '01' , 31);
insert into SC values('06' , '03' , 34);
insert into SC values('07' , '02' , 89);
insert into SC values('07' , '03' , 98);

create table Course(Cid varchar(10),Cname varchar(10),Tid varchar(10));
insert into Course values('01' , '语文' , '02');
insert into Course values('02' , '数学' , '01');
insert into Course values('03' , '英语' , '03');

create table Teacher(Tid varchar(10),Tname varchar(10));
insert into Teacher values('01' , '张三');
insert into Teacher values('02' , '李四');
insert into Teacher values('03' , '王五');

# 1. 查询" 01 "课程比" 02 "课程成绩高的学生的信息及课程分数

select s.*, a.score as score_01, b.score as score_02
from student s,
	(select sid, score from SC where Cid=01) a,
	(select sid, score from SC where Cid=02) b
where a.sid = b.sid and a.score > b.score and s.sid = a.sid;

# 2. 查询平均成绩大于等于 60 分的同学的学生编号和学生姓名和平均成绩

select s.Sid, Sname, avg(score) as avg_score
from student as s, sc where s.Sid = sc.Sid group by s.sid having avg_score > 60;

# answer
select s.sid, s.sname, avg(score) as avg_score
from student as s, sc
where s.sid = sc.sid
group by s.sid
having avg_score > 60;

# 3. 查询在 SC 表存在成绩的学生信息

select * from Student where sid in (select sid from sc where score is not null);

# 4. 查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩(没成绩的显示为 null )

select s.sid, s.sname, count(cid) as 选课总数, sum(score) as 总成绩
from student as s left join sc
on s.sid = sc.sid
group by s.sid, sname;

# answer
# group by 需要加上 sname
select s.sid, s.sname, count(cid) as 选课总数, sum(score) as 总成绩
from student as s left join sc
on s.sid = sc.sid
group by s.sid;


# 5. 查有成绩的学生信息

select s.* from Student as s
where s.sid in (select sc.sid from sc where sc.score is not null);

# answer
select s.sid, s.sname, count(cid) as 选课总数, sum(score) as 总成绩,
	sum(case when cid=01 then score else null end) as 科目一成绩,
	sum(case when cid=02 then score else null end) as 科目二成绩,
	sum(case when cid=03 then score else null end) as 科目三成绩
from student as s, sc
where s.sid = sc.sid
group by s.sid, s.sname;

# 6. 查询「李」姓老师的数量
select count(t.Tname) as 【李】姓老师的数量 from Teacher as t where t.Tname like '李%';

# 7. 查询学过「张三」老师授课的同学的信息
select s.*, sc.score as 课程成绩
from Student as s, sc, Teacher as t
where s.sid = sc.sid and sc.Tid = t.Tid
group by s.sid, s.sname;

# answer
select s.* from Student as s
where sid in (
	select sid from sc, Course as c, Teacher as t
    where sc.cid = c.cid
		and c.Tid = t.Tid
        and t.Tname = '张三'
);

# 8. 查询没有学全所有课程的同学的信息

select * from Student as s
where sid in (
	select sid from sc
    group by sid
    having count(cid) < 3
);

# - 以上课程数量3值得商榷，需要查询得出
# - 子语句中查询不出所修课程数为0的王菊这条数据
# where是inner join，不会出现null, 所以出现上述问题

select s.sid, s.sname ,count(c.sid) as counts
from student s
left JOIN sc c on s.Sid = c.Sid
GROUP BY s.Sid, s.sname
HAVING counts < (SELECT count(*) from course);

# 9. 查询和" 01 "号的同学学习的课程完全相同的其他同学的信息

# 错误答案，在新增测试用例9.1之后，依然返回sid=04的「李云」同学的信息
select * from Student as s where sid in (
select B.sid from
	(select sid,
		sum(case when cid=01 then 1 else 0 end) as course_01,
		sum(case when cid=02 then 1 else 0 end) as course_02,
		sum(case when cid=03 then 1 else 0 end) as course_03
	from sc where sid = 01 group by sid) as A,

	(select sid,
		sum(case when cid=01 then 1 else 0 end) as course_01,
		sum(case when cid=02 then 1 else 0 end) as course_02,
		sum(case when cid=03 then 1 else 0 end) as course_03
	from sc where sid != 01 group by sid) as B
	where A.course_01=B.course_01 and A.course_02=B.course_02 and A.course_03=B.course_03
);

# WRONG answer
# 查询和" 01 "号的同学学习的课程完全相同的其他同学的信息 这题原作者错了，不能那样写。得到结果正确是刚好3门课程01同学全部都选了，如果01同学只选了两门课程，那么结果就不正确

select * from Student
where Sid in(
    select Sid from SC
    where Cid in (select Cid from SC where Sid = '01') and Sid <>'01'
    group by Sid
    having COUNT(Cid)>=3
);

# 测试用例9.1：新增一门化学课程，并新增李云同学选修了化学课程的记录
insert into Course values('04' , '化学' , '03');
insert into SC values('04' , '04' , 40);

# Right answer

# 思路 源自于https://blog.csdn.net/qq_41080850/article/details/84648897
# 01号之外的其他学生可以分成两个大类，一类是选修了01号学生没有选修的课程的学生，另一类学生选修的课程是01号学生选修的课程的子集。
# 采用逆向思维，可以先找出选修了01号学生没选课程的学生编号，然后以01号学生选修的课程数量为筛选条件，
# 从剩下的选修的课程是01号学生选修的课程的子集这类学生中筛选出与01号学生所选课程完全相同的学生编号，此编号包含了01，
# 以剔除了01之后的编号为筛选条件，从student表中选出和01号同学学习的课程完全相同的其他同学的信息。

select * from student where sid in
(select sid from sc where sid not in
(select sid from sc where cid not in (select cid from sc where sid='01'))
group by sid
having count(*)=(select count(*) from sc where sid='01') and sid != '01');


# Right answer
# 流程 ：查询 和 01号同学 课程 数量一样的 其他 同学
# 再把数量一样的 同学 inner join 01 号同学的课程信息。  如果数量还是一样则课程相同
select * from student s
where s.sid in (
select s.sid from
(select s.sid,sc.cid from (
select sid from sc where sid
and sid != '01'
group by sid
having count(*)=(select count(*) from sc where sid='01')
) s ,sc where sc.sid = s.sid
) s
right join (select cid from sc where sid='01') c
on c.cid = s.cid
group by sid
having count(*)=(select count(*) from sc where sid='01')
);

# 10. 查询至少有一门课与学号为" 01 "的同学所学相同的同学的信息
select s.* from Student as s where sid in (
	select distinct sid from sc where cid in (
		select cid from sc where sid=01
	) and sid != 01
);

# 11. 查询没学过"张三"老师讲授的任一门课程的学生姓名

select * from Student as s, sc, course as c where s.sid=sc.sid and sc.cid=c.cid;


(select cid from course as c, Teacher as t
where c.tid=t.tid and t.Tname='张三');


# answer

select sname from student
where sname not in (
    select s.sname
    from student as s, course as c, teacher as t, sc
    where s.sid = sc.sid
        and sc.cid = c.cid
        and c.tid = t.tid
        and t.tname = '张三'
);

# 12. 查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩

select distinct s.sid, s.sname, avg(score)
from Student as s, sc, (
	select A.sid from (
		select sid, count(sid) as unpass_count from sc where score<60 group by sid
		) as A where unpass_count>=2
    ) as B
where s.sid = B.sid and s.sid = sc.sid group by s.sid, s.sname;

# answer
select s.sid, s.sname, avg(score)
from student as s, sc
where s.sid = sc.sid and score<60
group by s.sid, s.sname
having count(score)>=2;

select s.sid, s.sname, score
from Student as s, sc
where s.sid=sc.sid and sc.score<60;

# 13. 检索" 01 "课程分数小于 60，按分数降序排列的学生信息

select s.*, sc.score from Student as s, sc where cid=01 and s.sid=sc.sid and sc.score<60 order by score desc;


# 14. 按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩

select s.sid, s.sname,
	sum(case when cid=01 then score else null end) as course_01,
	sum(case when cid=02 then score else null end) as course_02,
	sum(case when cid=03 then score else null end) as course_03,
    avg(score) as 平均成绩
from student as s, sc
where s.sid = sc.sid
group by s.sid, s.sname
order by 平均成绩 desc;

# 15. 查询各科成绩最高分、最低分和平均分，
# 以如下形式显示：课程 ID，课程 name，最高分，最低分，平均分，及格率，中等率，优良率，优秀率(及格为>=60，中等为：70-80，优良为：80-90，优秀为：>=90）。
# 要求输出课程号和选修人数，查询结果按人数降序排列，若人数相同，按课程号升序排列

select c.cid, c.cname, count(sid) as 选修人数,
	max(score) as 最高分, min(score) as 最低分, avg(score) as 平均分,
    sum(case when score>=60 then 1 else 0 end) / count(sid) as 及格率,
    sum(case when score>=70 and score<80 then 1 else 0 end) / count(sid) as 中等率,
    sum(case when score>=80 and score<90 then 1 else 0 end) / count(sid) as 优良率,
    sum(case when score>=90 then 1 else 0 end) / count(sid) as 优秀率
from sc, Course as c
where sc.cid = c.cid
group by sc.cid, c.Cname
order by 选修人数 desc, cid asc;

# 16. 按平均成绩进行排序，显示总排名和各科排名，Score 重复时保留名次空缺

select s.sid, s.sname, avg(score) as 平均成绩
from Student as s, sc
where s.sid = sc.sid
group by s.sid, s.sname
order by 平均成绩 desc;

# 17. 统计各科成绩各分数段人数：课程编号，课程名称，[100-85]，[85-70]，[70-60]，[60-0] 及所占百分比

select c.cid as 课程编号, c.cname as 课程名称,
	sum(case when score<60 then 1 else 0 end) / count(sid) as 60_0,
	sum(case when score>=60 and score<70 then 1 else 0 end) / count(sid) as 70_60,
	sum(case when score>=70 and score<85 then 1 else 0 end) / count(sid) as 85_70,
	sum(case when score>=85 and score<100 then 1 else 0 end) / count(sid) as 100_85
from sc, Course as c
where sc.cid = c.cid
group by c.cid, c.cname
order by c.cid asc;

# 18. 查询各科成绩排名的记录

select s.sid, sc.cid, sc.score
from Student as s, sc
where s.sid=sc.sid
group by sc.cid, sc.score, s.sid
order by sc.cid asc, sc.score desc;

# 19. 查询各科成绩前三名的记录

select * from (
	select *, rank() over (
		partition by cid order by score desc) as graderank from sc
	) as A
where A.graderank <=3;

# 20. 查询出只选修两门课程的学生学号和姓名

select s.sid, s.sname, count(cid) as course_count
from Student as s, sc
where s.sid = sc.sid
group by s.sid, s.sname
having course_count = 2;

# 21. 查询名字中含有「风」字的学生信息

select s.* from Student as s where s.Sname like '%风%';

# 22. 查询 1990 年出生的学生名单

select * from Student as s where s.Sage like '1990%';

# 23. 成绩不重复，查询选修「张三」老师所授课程的学生中，成绩最高的学生信息及其成绩

select s.sid as 学生编号, s.sname as 学生名称,
sc.cid as 课程编号, c.Cname as 课程名称, t.tname as 授课老师, max(score) as 最高分
from Student as s, sc, Course as c, Teacher as t
where s.sid = sc.sid and sc.cid = c.cid and c.tid = t.tid and t.tname = '张三'
group by s.sid, s.sname, sc.cid, c.cname, t.tname
limit 0, 1;

# 另一种简单的写法
select s.* , sc.score
from Student s, Teacher t, Course c, SC sc
where s.sid = sc.sid
and sc.cid = c.cid
and c.tid = t.tid
and t.tname = '张三'
order by sc.score desc
limit 1;

# 24. 成绩有重复的情况下，查询选修「张三」老师所授课程的学生中，成绩最高的学生信息及其成绩

# 按要求插入成绩重复学生成绩信息
insert into Student values('09' , '重复' , '1990-01-01' , '男');

insert into SC values('09' , '01' , 80);
insert into SC values('09' , '02' , 90);
insert into SC values('09' , '03' , 99);

# 新增一个名为「重复」的学生，其各科成绩和「赵雷」同学一样
# 这时23题的命令只能查询到赵雷同学的成绩信息
# 一是where是inner join, 二是limit函数去掉了其他同学的信息

select s.*, sc.score
from Student as s left join sc on s.sid = sc.sid
left join Course as c on sc.cid = c.cid
left join Teacher as t on c.tid = t.tid
where t.Tname = '张三'
order by sc.score desc
limit 1;

# 分解过程
# A. 查询张三老师全部的授课课程

select Cid from Course where Tid=(select Tid from Teacher where Tname='张三');

# B. 查询张三老师全部的授课中学生成绩排名

select *, DENSE_RANK() over (order by score desc) as A
    from SC
where Cid = (select Cid from Course where Tid=(select Tid from Teacher where Tname='张三'));

# C. 查询排名名次为「1」的学生名单

select * from (
	select *, dense_rank() over (order by sc.score desc) as srank
		from sc
	where sc.cid = (select c.cid from Course as c where c.tid = (select t.tid from Teacher as t where t.Tname = '张三'))
) as 张三老师课程学生成绩排名, Student as s
where s.sid = 张三老师课程学生成绩排名.sid and 张三老师课程学生成绩排名.srank = 1;

# 25. 查询各学生的年龄，只按年份来算

select s.sid, s.sname, s.Sage, year(now())-year(s.Sage) as age from Student as s;

# 26. 按照出生日期来算，当前月日 < 出生年月的月日则，年龄减一

select s.sname, s.Sage, timestampdiff(year, s.sage, now()) as age from Student as s;

# 27. 查询本周过生日的学生

select * from student where week(now()) = week(sage);

# 28. 查询本月过生日的学生

select * from Student as s where month(now()) = month(s.Sage);

# 29. 查询下月过生日的学生

select * from Student as s where (month(now())+1) = month(s.Sage);
