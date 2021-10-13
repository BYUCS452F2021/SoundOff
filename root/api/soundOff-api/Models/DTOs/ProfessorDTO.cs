using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace soundOff_api.Models.DTOs
{
    public class ProfessorDTO
    {
        public uint Id { get; set; }
        public string Name { get; set; }
        public string Degree { get; set; }
        public string Department { get; set; }
        public string Email { get; set; }
        public string Password { get; set; }
        public List<ClassDTO> Classes { get; set; }

        public ProfessorDTO() {
            Classes = new List<ClassDTO>();
        }
        public ProfessorDTO(Professor p)
        {
            Classes = new List<ClassDTO>();
            Id = p.Id;
            Name = p.Name;
            Degree = p.Degree;
            Department = p.Department;
            Email = p.Email;
            Password = p.Password;

            if (p.Classes != null)
                foreach (var c in p.Classes)
                    Classes.Add(new ClassDTO(c));
        }
    }
}
