using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace soundOff_api.Models.DTOs
{
    public class ClassDTO
    {
        public uint Id { get; set; }
        public string SectionNumber { get; set; }
        public string ClassName { get; set; }
        public Professor Professor { get; set; }
        public List<AttendanceDTO> Attendances { get; set; }
        public List<StudentDTO> Students { get; set; }

        public ClassDTO() {
            Attendances = new List<AttendanceDTO>();
            Students = new List<StudentDTO>();
        }
        public ClassDTO(Class c)
        {
            Id = c.Id;
            SectionNumber = c.SectionNumber;
            ClassName = c.ClassName;
            Attendances = new List<AttendanceDTO>();
            Students = new List<StudentDTO>();

            if (c.Attendances != null)
                foreach (var a in c.Attendances)
                    Attendances.Add(new AttendanceDTO(a));

            if (c.Enrollments != null)
                foreach (var e in c.Enrollments)
                    if (e.Student != null)
                        Students.Add(new StudentDTO(e.Student));

        }
    }
}
