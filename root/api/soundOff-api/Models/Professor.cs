using System;
using System.Collections.Generic;

#nullable disable

namespace soundOff_api.Models
{
    public partial class Professor
    {
        public uint Id { get; set; }
        public string Name { get; set; }
        public string Degree { get; set; }
        public string Department { get; set; }
        public string Email { get; set; }
        public string Password { get; set; }
        public List<Class> Classes { get; set; }
    }
}
