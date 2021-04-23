package org.thp.thehive.services

import org.thp.scalligraph.query.PredicateOps
import org.thp.scalligraph.traversal.TraversalOps

object TheHiveOps {
  def apply[A](orgSrv: OrganisationSrv)(body: TheHiveOps => A): A =
    body(new TheHiveOps {
      override protected val organisationSrv: OrganisationSrv = orgSrv
    })
}
trait TheHiveOps
    extends TheHiveOpsNoDeps
    with TaskOps
    with PatternOps
    with AuditOps
    with TaxonomyOps
    with ImpactStatusOps
    with ObservableTypeOps
    with ProfileOps
    with ShareOps
    with CaseTemplateOps
    with ConfigOps
    with LogOps
    with PageOps
    with ObservableOps
    with UserOps
    with AttachmentOps
    with DashboardOps
    with ProcedureOps
    with DataOps
    with CustomFieldOps
    with CaseOps
    with AlertOps
    with ReportTagOps
    with ResolutionStatusOps
    with TagOps
    with RoleOps
    with OrganisationOps

trait TheHiveOpsNoDeps
    extends TraversalOps
    with PredicateOps
    with TaskOpsNoDeps
    with PatternOps
    with AuditOpsNoDeps
    with TaxonomyOps
    with ImpactStatusOps
    with ObservableTypeOps
    with ProfileOps
    with ShareOps
    with CaseTemplateOps // TODO CustomFields
    with ConfigOps
    with LogOpsNoDeps
    with PageOps
    with ObservableOpsNoDeps
    with UserOps
    with AttachmentOps
    with DashboardOps
    with ProcedureOps
    with DataOps
    with CustomFieldOps
    with CaseOpsNoDeps  // TODO CustomFields
    with AlertOpsNoDeps // TODO CustomFields
    with ReportTagOps
    with ResolutionStatusOps
    with TagOpsNoDeps
    with RoleOps
    with OrganisationOps
