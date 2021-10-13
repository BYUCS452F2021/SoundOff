using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace soundOff_api.Models.DTOs
{
    public class StudentDTO
    {
        public uint Id { get; set; }
        public string Name { get; set; }
        public string Major { get; set; }
        public string Phone { get; set; }
        public string Email { get; set; }
        public string Password { get; set; }
        public List<AttendanceDTO> Attendances { get; set; }
        public List<ClassDTO> Classes { get; set; }

        public StudentDTO()
        {
            Attendances = new List<AttendanceDTO>();
            Classes = new List<ClassDTO>();
        }

        public StudentDTO(Student s)
        {
            Attendances = new List<AttendanceDTO>();
            Classes = new List<ClassDTO>();

            Id = s.Id;
            Name = s.Name;
            Major = s.Major;
            Phone = s.Phone;
            Email = s.Email;
            Password = s.Password;

            if (s.Attendances != null)
                foreach (var a in s.Attendances)
                    Attendances.Add(new AttendanceDTO(a));

            if (s.Enrollments != null)
                foreach (var e in s.Enrollments)
                    if (e.Class != null)
                            Classes.Add(new ClassDTO(e.Class));
        }
    }
}
