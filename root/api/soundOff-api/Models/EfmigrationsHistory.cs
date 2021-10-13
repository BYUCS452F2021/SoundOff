using System;
using System.Collections.Generic;

#nullable disable

namespace soundOff_api.Models
{
    public partial class EfmigrationsHistory
    {
        public string MigrationId { get; set; }
        public string ProductVersion { get; set; }
    }
}
