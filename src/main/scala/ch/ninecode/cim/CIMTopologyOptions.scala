package ch.ninecode.cim

import org.apache.spark.storage.StorageLevel

sealed trait State

case object ForceTrue extends State
case object ForceFalse extends State
case object Unforced extends State

/**
 * Topological processing options.
 *
 * This class determines the behaviour of the CIMNetworkTopologyProcessor.
 *
 * @param identify_islands When <code>true</code>, topological islands are identified in addition to
 * topological nodes. That is, <code>TopologicalNode</code> objects generated by the processor will have a valid
 * <code>TopologicalIsland</code> attributes that reference generated <code>TopologicalIsland</code> objects.
 * @param force_retain_switches Keep Switch and subclasses as two topological node elements irregardless of the
 * <code>retained</code> attribute, or the <code>open</code> and <code>normalOpen</code>
 * attributes.
 * This is used for alternative scenario calculations.
 * It allows the user to override the behaviour when the processor encounters a Switch
 * or a Switch derived class (e.g. Disconnector),
 * except Fuse and ProtectiveSwitch classes are not included by this flag.
 * The default behaviour of <code>Unforced</code>
 * will use the value of the <code>retained</code> attribute to identify a node boundary
 * only if the attribute is present in the CIM file and the value is <code>true</code>.
 * When set to <code>ForceTrue</code> the behaviour is equivalent to each Switch having a <code>retained</code>
 * attribute with value <code>true</code>.
 * When set to <code>ForceFalse</code> the behaviour is equivalent to each Switch having a <code>retained</code>
 * attribute with value <code>false</code>.
 * @param force_retain_fuses Keep Fuse, ProtectedSwitch and subclasses as two topological node elements irregardless of the
 * <code>retained</code> attribute, or the <code>open</code> and <code>normalOpen</code>
 * attributes.
 * This is used for fuse specificity calculation.
 * It allows the user to override the normal behaviour when a Fuse is encountered, which is to keep the two
 * terminals as two topological nodes only if the <code>retained</code> attribute is present and true
 * or the <code>open</code> attribute is present and has a value <code>true</code>
 * or if <code>open</code> attribute is not present and the <code>normalOpen</code> attribute has a value <code>true</code>.
 * This has the same effect for Fuse objects as <code>force_retain_switches</code> does for Switch objects.
 * @param force_switch_separate_islands Extends the retain attribute to <code>TopologicalIsland</code> processing
 * for <code>Switch</code> derived objects, except for <code>Fuse</code> and <code>ProtectedSwitch</code> objects.
 * The default of <code>Unforced</code> uses the open or normalOpen attributes, if present, or the
 * <code>default_switch_open_state</code> setting otherwise, to determine if a switch separates two islands.
 * <code>ForceTrue</code> keeps the switch in two islands, irregardless of the switch state, while
 * <code>ForceFalse</code> ensures the switch is in only one island.
 * @param force_fuse_separate_islands Similar functionality as force_switch_separate_islands,
 * but for <code>Fuse</code> objects.
 * @param default_switch_open_state Allows changing the behaviour when the processor encounters a Switch
 * that has neither an <code>open</code> attribute, nor  <code>normalOpen</code> attribute.
 * The default behaviour of <code>false<code> is the same as if <code>open</code> and <code>normalOpen</code>
 * both specify <code>false</code>.
 * @param debug If <code>true</code> additional tests are performed during topology processing:
 *
 - unique VertexId for every ConnectivityNode mRID (checks the hash function)
 - all edges reference existing ConnectivityNode elements (checks for completeness)
 - no voltage transitions (checks that edges that are joined have the same BaseVoltage)
 * @param storage The storage level for new and replaced CIM RDD.
 */
case class CIMTopologyOptions
(
    identify_islands: Boolean = false,
    force_retain_switches: State = Unforced,
    force_retain_fuses: State = Unforced,
    force_switch_separate_islands: State = Unforced,
    force_fuse_separate_islands: State = Unforced,
    default_switch_open_state: Boolean = false,
    debug: Boolean = false,
    storage: StorageLevel = StorageLevel.MEMORY_AND_DISK_SER
)