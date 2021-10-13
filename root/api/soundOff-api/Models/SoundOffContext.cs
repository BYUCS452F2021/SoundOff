using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

#nullable disable

namespace soundOff_api.Models
{
    public partial class SoundOffContext : DbContext
    {
        public SoundOffContext()
        {
        }

        public SoundOffContext(DbContextOptions<SoundOffContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Attendance> Attendances { get; set; }
        public virtual DbSet<Class> Classes { get; set; }
        public virtual DbSet<Code> Codes { get; set; }
        public virtual DbSet<EfmigrationsHistory> EfmigrationsHistories { get; set; }
        public virtual DbSet<Enrollment> Enrollments { get; set; }
        public virtual DbSet<Professor> Professors { get; set; }
        public virtual DbSet<Student> Students { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see http://go.microsoft.com/fwlink/?LinkId=723263.
                optionsBuilder.UseMySql("server=lsjeremy.byu.edu;port=3306;user=soundOff;password=CS452Fall2021!;database=SoundOff;treattinyasboolean=false", Microsoft.EntityFrameworkCore.ServerVersion.Parse("8.0.26-mysql"));
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.HasCharSet("utf8mb4")
                .UseCollation("utf8mb4_0900_ai_ci");

            modelBuilder.Entity<Attendance>(entity =>
            {
                entity.HasIndex(e => e.Id, "Id_UNIQUE")
                    .IsUnique();
            });

            modelBuilder.Entity<Class>(entity =>
            {
                entity.HasIndex(e => e.Id, "Id_UNIQUE")
                    .IsUnique();

                entity.Property(e => e.SectionNumber).HasMaxLength(45);
            });

            modelBuilder.Entity<Code>(entity =>
            {
                entity.HasIndex(e => e.Id, "Id_UNIQUE")
                    .IsUnique();
            });

            modelBuilder.Entity<EfmigrationsHistory>(entity =>
            {
                entity.HasKey(e => e.MigrationId)
                    .HasName("PRIMARY");

                entity.ToTable("__EFMigrationsHistory");

                entity.Property(e => e.MigrationId).HasMaxLength(150);

                entity.Property(e => e.ProductVersion)
                    .IsRequired()
                    .HasMaxLength(32);
            });

            modelBuilder.Entity<Enrollment>(entity =>
            {
                entity.HasIndex(e => e.Id, "Id_UNIQUE")
                    .IsUnique();
            });

            modelBuilder.Entity<Professor>(entity =>
            {
                entity.HasIndex(e => e.Id, "Id_UNIQUE")
                    .IsUnique();
            });

            modelBuilder.Entity<Student>(entity =>
            {
                entity.HasIndex(e => e.Id, "Id_UNIQUE")
                    .IsUnique();
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
